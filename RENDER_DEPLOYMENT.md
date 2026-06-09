# Deploy no Render.com - Album Copa

## ⚡ Quick Start

### 1. Preparar o projeto

Certifique-se que:
- ✅ `Dockerfile` está no root do projeto
- ✅ Código está commitado no Git (GitHub, GitLab, etc.)
- ✅ Arquivo `render.yaml` está no root

### 2. Conectar ao Render

1. Acesse [render.com](https://render.com)
2. Faça login ou crie conta
3. Clique em **"New +"** → **"Blueprint"**
4. Conecte seu repositório Git
5. Selecione o branch principal (main/master)
6. Clique em **"Deploy"**

### 3. Configurar Variáveis de Ambiente

Após o deploy, configure no **Dashboard do Render**:

#### Secrets (Configure manualmente):
```
JWT_SECRET=sua_chave_jwt_super_segura_com_256_bits_minimo
CLOUDINARY_URL=cloudinary://api_key:api_secret@cloud_name
```

#### Banco de Dados:
- O PostgreSQL será criado automaticamente pelo `render.yaml`
- Credenciais serão injetadas automaticamente

### 4. Health Check

O Render usará automaticamente:
```
GET /actuator/health
```

## 🔧 Otimizações para Render

### Build Time
- O Gradle fará cache automático
- Primeira build: ~3-5 minutos
- Builds subsequentes: ~1-2 minutos

### Recursos
- Plano **Free**: 0.5 GB RAM (limite mínimo)
- Plano **Standard**: 0.5 GB RAM recomendado para produção
- Aumente conforme necessário

### Alternativa: Deploy sem Blueprint (Manual)

Se preferir configurar manualmente:

1. **Web Service**
   - Conectar repositório
   - Build command: (deixar em branco - Docker)
   - Runtime: Docker
   - Instance type: Standard

2. **PostgreSQL Database**
   - Plan: Free ou Standard
   - Version: 16
   - Database name: `album_copa`
   - User: `album_user`

## 📝 Configurações Manuais Necessárias

### No Dashboard do Render:

#### Web Service (album-copa)
1. **Environment** → Adicione:
   ```
   JWT_SECRET = <sua_chave>
   CLOUDINARY_URL = <sua_url>
   SPRING_PROFILES_ACTIVE = prod
   ```

2. **Redirect HTTP to HTTPS**: ✅ Enabled
3. **Auto-deploy**: ✅ Enabled

#### PostgreSQL
1. Copie a **Internal Database URL**
2. Será automaticamente injetada como `DATABASE_URL`

## 🚀 Monitoramento

### Logs em Tempo Real
```
Render Dashboard → Services → album-copa → Logs
```

### Métricas
- CPU Usage
- Memory Usage
- Network I/O
- Restart Count

## 🔐 Segurança

✅ HTTPS automático (certificado Let's Encrypt)
✅ Database em VPC privada
✅ Firewall automático
✅ Non-root user no container

## 🐛 Troubleshooting

### Build falha
```
Verificar os logs no Render Dashboard
Erro comum: Falta de memória durante Gradle build
Solução: Aumentar para Standard ou usar cache
```

### Não consegue conectar ao banco
```
1. Verificar URL de conexão
2. Verificar firewall (deve estar aberto)
3. Reiniciar o banco de dados
```

### Aplicação reiniciando constantemente
```
1. Verificar logs
2. Aumentar memória
3. Verificar JWT_SECRET e CLOUDINARY_URL
```

## 📊 Limites Grátis (Free Tier)

- ⏱️ Auto-pausa: 15 minutos sem requisições
- 💾 Disco: 10 GB
- 🧠 RAM: 0.5 GB
- 🌐 Banda: 100 GB/mês

## 💾 Backup do Banco

No Render Dashboard:
1. PostgreSQL → Backups
2. Criar backup manual antes de mudanças importantes
3. Backups automáticos a cada 24h

## 🔄 Redeploy Manual

Se precisar fazer redeploy sem novo commit:

Render Dashboard → album-copa → **Manual Deploy** → **Deploy latest commit**

## ⚙️ Escalar para Produção

Quando tiver mais tráfego:

1. Upgrade para **Standard** ou **Pro**
2. Aumentar instâncias (replicas)
3. Usar CDN do Render
4. Adicionar cache com Redis

## 📞 Suporte

- [Render Docs](https://render.com/docs)
- [Status Page](https://status.render.com)
- Email: support@render.com

