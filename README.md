# Proyecto_RentaHerramientas_PerezJaider_ArevaloRicardo

`# **ConstructTools - Plataforma de Alquiler de Herramientas**  

## **📌 Resumen del Proyecto**  
**ConstructTools** es una plataforma web diseñada para facilitar el alquiler de herramientas de construcción entre clientes y proveedores. El sistema cuenta con tres roles principales (**Cliente**, **Proveedor** y **Administrador**), cada uno con funcionalidades específicas para gestionar herramientas, reservas y pagos de manera eficiente.  

---

## **✨ Características Principales**  

### **🔐 Autenticación y Seguridad**  
- **Registro y login** con validación de datos y contraseñas encriptadas.  
- **Tokens JWT** para mantener sesiones seguras.  
- **Control de acceso basado en roles** (permisos específicos para cada tipo de usuario).  

### **👥 Gestión de Usuarios**  
- **Clientes**: Pueden buscar herramientas, realizar reservas y gestionar sus alquileres.  
- **Proveedores**: Administran su inventario, aprueban solicitudes y reciben pagos.  
- **Administradores**: Supervisan toda la plataforma, gestionan usuarios y generan reportes.  

### **🛠️ Catálogo de Herramientas**  
- Búsqueda y filtrado de herramientas por categoría, precio y disponibilidad.  
- Detalles completos de cada herramienta (descripción, precio, calificaciones).  

### **📅 Reservas y Pagos**  
- Proceso de alquiler con selección de fechas y cantidad.  
- Integración con pasarelas de pago (simulada en esta versión).  
- Historial de transacciones y facturación.  

### **📊 Dashboards Interactivos**  
- **Clientes**: Ven sus reservas activas y próximas devoluciones.  
- **Proveedores**: Monitorean ingresos, herramientas más rentables y solicitudes pendientes.  
- **Administradores**: Acceden a métricas globales de la plataforma.  

---

## **🚀 Tecnologías Utilizadas**  

### **Frontend**  
- **HTML5**, **CSS3** (Flexbox, Grid)  
- **JavaScript** (manejo del DOM, fetch API)  
- **Responsive Design** (compatible con móviles y tablets)  

### **Backend**  
- **Java 17** + **Spring Boot 3** (API RESTful)  
- **Spring Security** + **JWT** (autenticación)  
- **PostgreSQL** (base de datos relacional)  
- **Maven** (gestión de dependencias)  

### **Herramientas Adicionales**  
- **Git** (control de versiones)  
- **Postman** (pruebas de API)  

---

## **📌 Beneficios del Sistema**  
✅ **Ahorro de costos**: Los clientes alquilan herramientas en lugar de comprarlas.  
✅ **Mayor alcance para proveedores**: Pueden rentabilizar su inventario ocioso.  
✅ **Gestión centralizada**: Los administradores tienen control total sobre la plataforma.  
✅ **Experiencia intuitiva**: Interfaz limpia y fácil de usar para todos los roles.  

---

## **🔮 Futuras Mejoras**  
- Implementar **pagos en línea** con Stripe o PayPal.  
- Añadir **sistema de reseñas** para herramientas.  
- Desarrollar una **app móvil** complementaria.  
- Integrar **notificaciones en tiempo real** con WebSockets.  

---

## **📄 Licencia**  
Este proyecto está bajo licencia **MIT**.  

---

## **🤝 ¿Cómo Contribuir?**  
1. Haz un **fork** del repositorio.  
2. Crea una rama con tu feature: `git checkout -b mi-feature`.  
3. Haz commit de tus cambios: `git commit -m "Añade nueva funcionalidad"`.  
4. Haz push a la rama: `git push origin mi-feature`.  
5. Abre un **Pull Request** y ¡listo!  

---

### **💡 ¿Preguntas o Feedback?**  
¡Contáctame! ✉️ **tuemail@ejemplo.com**  

--- 

**ConstructTools** no solo simplifica el alquiler de herramientas, sino que también impulsa la productividad en el sector de la construcción. 🚧💡

| Tecnología           | Uso                              |
|----------------------|----------------------------------|
| Java 17              | Lenguaje principal              |
| Spring Boot 3.x      | Framework backend               |
| Spring Security      | Autenticación y autorización    |
| JWT                  | Tokens de sesión                |
| Lombok               | Reducción de código boilerplate |
| Maven                | Gestión de dependencias         |

## 📂 Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/herramientas/api/
│   │       ├── application/            # Lógica de negocio
│   │       │   ├── services/           # Servicios principales
│   │       │   └── services/auth/      # Servicios de autenticación
│   │       ├── config/                 # Configuraciones
│   │       │   ├── security/           # Seguridad JWT
│   │       │   └── filter/             # Filtros HTTP
│   │       ├── controller/             # Controladores REST
│   │       ├── dto/                    # Objetos de transferencia
│   │       ├── exception/              # Manejo de errores
│   │       └── persistence/            # Capa de datos
│   │           ├── entity/             # Entidades JPA
│   │           ├── repositories/       # Repositorios Spring Data
│   │           └── utils/              # Utilidades
│   └── resources/                      # Configuraciones
└── test/                               # Pruebas
```


### Flujo JWT:
1. Cliente envía credenciales → `/auth/authenticate`
2. Servidor valida y retorna JWT
3. Cliente incluye JWT en header `Authorization: Bearer <token>`



## 🚀 Endpoints Clave

| Método | Endpoint                | Descripción                     | Rol Requerido       |
|--------|-------------------------|---------------------------------|---------------------|
| POST   | `/auth/authenticate`    | Autenticación de usuarios       | Público             |
| POST   | `/customers`            | Registro de nuevos clientes     | Público             |
| GET    | `/tools`                | Listar herramientas             | Cliente/Proveedor   |
| POST   | `/tools`                | Crear herramienta               | Proveedor           |
| GET    | `/admin/users`          | Listar todos los usuarios       | Administrador       |

## 🛠️ Configuración Local

1. **Requisitos**:
   - Java 17+
   - Maven 3.8+
   - PostgreSQL 14+

2. **Instalación**:
   ```bash
   git clone https://github.com/tuusuario/constructtools-backend.git
   cd constructtools-backend
   mvn install
   ```

3. **Configuración**:
   Crear archivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/constructtools
   spring.datasource.username=postgres
   spring.datasource.password=tu_password
   spring.jpa.hibernate.ddl-auto=update
   jwt.secret=tu_secreto_jwt
   ```



## 🤝 Contribuir

1. Haz fork del proyecto
2. Crea tu rama: `git checkout -b feature/nueva-funcionalidad`
3. Haz commit: `git commit -m 'Añade X funcionalidad'`
4. Haz push: `git push origin feature/nueva-funcionalidad`
5. Abre un Pull Request



## 📥 Scripts y Pruebas con Postman

### 🛠️ Base de Datos PostgreSQL

#### 2. Conectarse a la base de datos
```bash
psql -U postgres
\c renttools
```

#### 3. Ejecutar los scripts
```sql
\postgres scripts.sql
\postgres inserts.sql
```

> Asegúrate de tener los archivos SQL en la carpeta `db/` del proyecto.

---

### 🧪 Colección de Postman

#### 1. Importar la colección
1. Abre Postman.
2. Ve a **Collections** > **Import**.
3. Selecciona el archivo `RentTools_Postman_Collection_FULL_FINAL.json` dentro de la carpeta `postman/`.

#### 2. Usuarios disponibles

| Rol        | Email                  | Contraseña |
|------------|------------------------|------------|
| Admin      | admin@example.com      | 12345678   |
| Cliente    | cliente@example.com    | 12345678   |
| Proveedor  | proveedor@example.com  | 12345678   |

#### 3. Uso
- Ejecuta primero la petición de login según el usuario.
- Copia el token JWT del resultado.
- Pega el token en la variable `{{token}}` o en el header `Authorization` como:  
  `Bearer <tu_token>`

> También puedes definir la variable `token` en la sección Variables de la colección para mayor comodidad.

---

📁 Estructura recomendada del proyecto para estos archivos:

```
renttools-resourses/
├── db/
│   ├── postgres scripts.sql
│   └── postgres inserts.sql
├── postman/
│   └── RentTools Postman Collection.json
```
   | DB_URL             | URL de la base de datos              | localhost:5432    |
   | JWT_SECRET         | Secreto para firmar JWT              | -                 |
   | JWT_EXPIRATION    | Tiempo de expiración del token (ms) | 86400000 (24h)    |
   ```

