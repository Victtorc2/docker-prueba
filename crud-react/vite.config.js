import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    host: '0.0.0.0',  // Esta línea permite que Vite acepte conexiones desde fuera del contenedor
    port: 5173,        // Asegúrate de que el puerto sea el correcto
  }
})
