# ✅ Checklist Deploy Render

## 🔧 Antes de fazer Push no Git

- [ ] Arquivo `Dockerfile` no root
- [ ] Arquivo `render.yaml` no root
- [ ] `src/main/resources/application-prod.yaml` configurado corretamente
- [ ] `.gitignore` inclui: `.env`, `build/`, `.gradle/`
- [ ] Todos os arquivos commitados no Git
- [ ] Branch principal (main/master) atualizado

## 🚀 Setup no Render

1. [ ] Ir em [render.com](https://render.com)
2. [ ] Fazer login
3. [ ] Clicar em **New +** → **Blueprint**
4. [ ] Conectar repositório Git
5. [ ] Fazer Fork/Deploy Blueprint
6. [ ] Aguardar build (3-5 minutos)

## 🔐 Configurar Secrets (Após Deploy)

Com o blueprint já deployado, configure manualmente no Dashboard:

### Web Service (`album-copa`)
Environment Variables:
```
JWT_SECRET=<gere uma chave de 256+ bits>
CLOUDINARY_URL=<sua_url_cloudinary>
SPRING_PROFILES_ACTIVE=prod
```

### Database (`album-copa-db`)
Será criado automaticamente pelo blueprint

## ✨ Customizações Opcionais

- [ ] Configurar CORS em `application-prod.yaml`
- [ ] Configurar logging em `application-prod.yaml`
- [ ] Adicionar domínio customizado no Render
- [ ] Configurar backup automático do banco

## 🧪 Testar Após Deploy

```bash
# Health Check
curl https://seu-app.onrender.com/actuator/health

# Metrics
curl https://seu-app.onrender.com/actuator/prometheus
```

## 📝 URL do Render

Após deploy, sua app estará em:
```
https://album-copa.onrender.com
```
(pode levar alguns minutos para estar disponível)

## 🔄 Redeploy

- Automático: push novo no Git
- Manual: Render Dashboard → Manual Deploy

## 💡 Dica

Se a build ficar muito lenta, você pode:
1. Aumentar o plano da Web Service para Standard
2. Usar `--build-cache` no Dockerfile
3. Considerar usar Gradle Build Cache (já incluído)

---

**Pronto para deploy! 🚀**

