# Інструкція з запуску проєкту

## 🗂 Структура проєкту

```
project-root/
├── client/     # фронтенд (React + Vite + TypeScript)
└── server/     # бекенд (Node.js + TypeScript)
```

## ✅ Запуск у продакшн-режимі

### 1. Бекенд (Node.js + TypeScript)

1. Перейдіть до папки сервера:
   ```bash
   cd server
   ```

2. Встановіть залежності:
   ```bash
   npm install
   ```

3. Зберіть TypeScript у JavaScript:
   ```bash
   npm run build
   ```

4. Запустіть продакшн-сервер:
   ```bash
   npm start
   ```

### 2. Фронтенд (React + Vite + TypeScript)

1. Перейдіть до папки клієнта:
   ```bash
   cd client
   ```

2. Встановіть залежності:
   ```bash
   npm install
   ```

3. Зберіть продакшн-бандл:
   ```bash
   npm run build
   ```

4. Перегляньте результат локально:
   ```bash
   npm run preview
   ```

## ⚠️ Примітки

* Сервер слухає порт 3001, API знаходиться на http://localhost:3001/notes
* Фронтенд (Vite Preview) знаходиться на http://localhost:4173

## 🔧 Технологічний стек

**Фронтенд:**
- React 19
- TypeScript
- Vite 6
- Axios для HTTP-запитів

**Бекенд:**
- Node.js
- TypeScript