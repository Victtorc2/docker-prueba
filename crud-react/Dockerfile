# Usar Node.js 18 LTS (más estable y compatible con la mayoría de las bibliotecas)
FROM node:18-slim

# Instalar dependencias necesarias, incluidas las de criptografía
RUN apt-get update && apt-get install -y \
    libssl-dev \
    && rm -rf /var/lib/apt/lists/*

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos package.json y package-lock.json
COPY package*.json ./

# Instalar las dependencias
RUN npm install

# Copiar el resto del código de la aplicación
COPY . .

# Exponer el puerto en el que React servirá la aplicación (generalmente 5173 con Vite)
EXPOSE 5173

# Comando para iniciar el servidor React con Vite en modo desarrollo
CMD ["npm", "run", "dev"]
