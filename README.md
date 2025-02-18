# 🛠️ Proyecto de Reuniones y Personas con Spring Boot

Este es un proyecto simple pero funcional que gestiona reuniones y personas utilizando **Spring Boot**, una base de datos en memoria **H2** y **Thymeleaf** para la vista en HTML. Además, incluye una API REST básica disponible en la ruta `/api/rest`.

## 🚀 Tecnologías Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Boot Starter Data REST**
- **H2 Database (en memoria)**
- **Thymeleaf**

## ⚙️ Instalación y Ejecución

1. **Clona el repositorio**
   ```bash
   git clone https://github.com/tuusuario/nombre-del-repo.git
   cd nombre-del-repo
   ```

2. **Construye y ejecuta la aplicación**
   ```bash
   mvn spring-boot:run
   ```

3. **Accede a la aplicación**
   - Interfaz web: [http://localhost:8080](http://localhost:8080)
   - API REST: [http://localhost:8080/api/rest](http://localhost:8080/api/rest)

## 🛠️ Funcionalidades

- **Gestión de personas**:❌ Crear, ✔ listar, ❌actualizar y ❌eliminar.
- **Gestión de reuniones**: Asignar personas a reuniones y visualizar información de las mismas.
- **API REST**: Datos accesibles en formato JSON.

## 🖥️ Vistas Disponibles

- **Inicio**: Lista de reuniones y personas.
- **Formulario**: Agregar/editar personas y reuniones. ❌

## 📦 Estructura del Proyecto
```
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.adrian.reuniones
│   │   │       ├── controller
│   │   │       ├── model
│   │   │       └── ...
│   │   └── resources
│   │       ├── application.yaml
│   │       └── templates
│   └── test
├── pom.xml
```

## 🔧 Configuración de la Base de Datos
La base de datos H2 está configurada en memoria y se accede desde:
- **Consola H2**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Usuario**: `sa`
- **Contraseña**: *(vacía por defecto)*



## 🧑‍💻 Autor
- **[Adrian](https://github.com/Adrian12ck)**

## ⚠️ Licencia
Este proyecto se distribuye bajo la licencia MIT. ¡Úsalo con libertad! 🎉

