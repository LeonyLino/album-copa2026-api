# 🔐 ALERTA SEGURANÇA - Credenciais Expostas

## ⚠️ Ação Urgente Necessária

Foi encontrado credenciais do banco de dados no arquivo `application-prod.yaml` que FOI COMMITADO NO GIT.

**Isso é um risco de segurança CRÍTICO!**

## 🚨 O que fazer IMEDIATAMENTE

### 1. Revogar credenciais expostas

Se você estava usando Neon (banco em nuvem):
1. Acesse seu painel Neon
2. Revogue a senha exposta: `album-copa-prod`
3. Crie uma nova senha
4. Atualize em um `.env` local ou secrets manager

### 2. Remover do histórico Git

```bash
# Ver histórico
git log --all --full-history -- src/main/resources/application-prod.yaml

# Remover do histórico (BFG Repo-Cleaner - mais seguro)
# Instalar: npm install -g bfg

# Ou usar git-filter-branch
git filter-branch --tree-filter 'rm -f src/main/resources/application-prod.yaml' HEAD

# Force push
git push origin --force --all
```

### 3. Atualizar .gitignore

Adicione ao arquivo `.gitignore`:
```
# Secrets
application-prod.yaml
.env
.env.local
.env.*.local
```

## ✅ Configuração Segura (JÁ FEITA)

O arquivo `application-prod.yaml` foi atualizado para usar **variáveis de ambiente**:

```yaml
spring:
  datasource:
    url: ${SPRING_DATASOURCE_URL}
    username: ${SPRING_DATASOURCE_USERNAME}
    password: ${SPRING_DATASOURCE_PASSWORD}
```

## 🔧 Como Configurar no Render

No Render Dashboard → Web Service → Environment:

```
SPRING_DATASOURCE_URL=jdbc:postgresql://seu-banco.com/db?sslmode=require
SPRING_DATASOURCE_USERNAME=seu_usuario
SPRING_DATASOURCE_PASSWORD=sua_senha
JWT_SECRET=sua_chave_jwt_segura
CLOUDINARY_URL=sua_url_cloudinary
```

## 📝 Checklist de Segurança

- [ ] Revogar credenciais antigas
- [ ] Remover do histórico Git
- [ ] Atualizar `.gitignore`
- [ ] Usar secrets do Render
- [ ] Fazer audit das outras branches
- [ ] Ativar branch protection no GitHub

## 🛡️ Best Practices

✅ **NUNCA** commitar secrets no Git
✅ Usar `.env` apenas localmente (em `.gitignore`)
✅ Usar secrets managers (Render, GitHub Secrets, AWS Secrets, etc)
✅ Rotacionar secrets regularmente
✅ Usar git-crypt ou similar para arquivos sensíveis
✅ Auditar histórico Git regularmente

## 📖 Referências

- https://owasp.org/www-community/Sensitive_Data_Exposure
- https://github.com/features/security#:~:text=github%20secret%20scanning
- https://bfg-repo-cleaner.github.io/

