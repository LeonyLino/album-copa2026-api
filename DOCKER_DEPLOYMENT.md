# Docker Deployment Guide - Album Copa

## Pré-requisitos

- Docker 20.10+
- Docker Compose 2.0+

## Estrutura dos Arquivos

- `Dockerfile` - Imagem multi-stage otimizada para produção
- `docker-compose.yml` - Orquestração da aplicação com PostgreSQL
- `.dockerignore` - Arquivos ignorados durante a build
- `.env.example` - Template de variáveis de ambiente

## Setup

### 1. Clonar as variáveis de ambiente

```bash
cp .env.example .env
```

Edite o arquivo `.env` com suas configurações reais:

```bash
DB_USERNAME=seu_usuario_bd
DB_PASSWORD=sua_senha_segura
JWT_SECRET=sua_chave_jwt_muito_segura
CLOUDINARY_URL=cloudinary://key:secret@cloud_name
```

### 2. Build da Imagem Docker

```bash
docker build -t album-copa:latest .
```

## Deployment com Docker Compose

### Iniciar a aplicação

```bash
docker-compose up -d
```

A aplicação estará disponível em: `http://localhost:8080`

### Visualizar logs

```bash
docker-compose logs -f app
```

### Parar a aplicação

```bash
docker-compose down
```

### Parar e remover volumes (dados do banco)

```bash
docker-compose down -v
```

## Verificações

### Health Check

```bash
curl http://localhost:8080/actuator/health
```

### Metrics (Prometheus)

```bash
curl http://localhost:8080/actuator/prometheus
```

## Deployment em Produção

### 1. Build multi-plataforma (arm64 + amd64)

```bash
docker buildx build --platform linux/amd64,linux/arm64 -t seu_registry/album-copa:latest --push .
```

### 2. Stack Docker Swarm

```bash
docker stack deploy -c docker-compose.yml album-copa
```

### 3. Kubernetes

```bash
kubectl apply -f k8s-manifests/
```

## Otimizações

✅ **Multi-stage build** - Reduz o tamanho final da imagem
✅ **Non-root user** - Melhora segurança
✅ **Health checks** - Monitoramento automático
✅ **Alpine/Slim images** - Base images otimizadas
✅ **Volumes persistentes** - Dados do PostgreSQL

## Troubleshooting

### Aplicação não inicia
```bash
docker-compose logs app
```

### Erro de conexão com banco
Verifique se o serviço `db` está healthy:
```bash
docker-compose ps
```

### Limpar cache de build
```bash
docker system prune -a
```

## Variáveis de Ambiente

| Variável | Descrição | Padrão |
|----------|-----------|--------|
| `SPRING_PROFILES_ACTIVE` | Perfil Spring | prod |
| `SERVER_PORT` | Porta da aplicação | 8080 |
| `SPRING_DATASOURCE_URL` | URL do banco | jdbc:postgresql://db:5432/album_copa |
| `DB_USERNAME` | Usuário do banco | album_user |
| `DB_PASSWORD` | Senha do banco | - |
| `JWT_SECRET` | Chave JWT | - |
| `CLOUDINARY_URL` | URL Cloudinary | - |

