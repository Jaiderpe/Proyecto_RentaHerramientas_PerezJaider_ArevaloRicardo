# Proyecto_RentaHerramientas_PerezJaider_ArevaloRicardo

```markdown
# 🚀 Backend de ConstructTools - API de Alquiler de Herramientas

![Arquitectura Backend](docs/backend-architecture.png)

API RESTful para el sistema de alquiler de herramientas con autenticación JWT, gestión de roles y permisos.

## 🌟 Características Clave

- **Autenticación segura** con JWT y BCrypt
- **Control de acceso basado en roles** (Admin, Proveedor, Cliente)
- **API RESTful** siguiendo mejores prácticas
- **Manejo centralizado de errores**
- **Validación de datos** en endpoints

## 🛠 Stack Tecnológico

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

## 🔐 Sistema de Autenticación

```java
// AuthenticationService.java
public AuthenticationResponse login(AuthenticationRequest authRequest) {
    Authentication authentication = new UsernamePasswordAuthenticationToken(
        authRequest.getUsername(), 
        authRequest.getPassword()
    );
    
    authenticationManager.authenticate(authentication);
    UserDetails user = userService.findOneByUsername(authRequest.getUsername()).get();
    String jwt = jwtService.generateToken(user, generateExtraClaims((User) user));
    
    return new AuthenticationResponse(jwt);
}
```

### Flujo JWT:
1. Cliente envía credenciales → `/auth/authenticate`
2. Servidor valida y retorna JWT
3. Cliente incluye JWT en header `Authorization: Bearer <token>`

## 🛡️ Configuración de Seguridad

```java
// HttpSecurityConfig.java
@Bean
SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(authReq -> {
            authReq.requestMatchers(HttpMethod.POST, "/customers").permitAll();
            authReq.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
            authReq.anyRequest().authenticated();
        })
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    
    return http.build();
}
```

## 📊 Modelo de Datos Principales

### Entidad Usuario
```java
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    
    private String nombre;
    private String email;
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_roles")
    private Set<Rol> roles = new HashSet<>();
}
```

### Enum de Roles
```java
public enum Role {
    ROLE_ADMINISTRATOR(Arrays.asList(
        RolePermission.READ_ALL_USERS,
        RolePermission.CREATE_USER
    )),
    ROLE_PROVIDER(Arrays.asList(
        RolePermission.MANAGE_OWN_TOOLS,
        RolePermission.ACCEPT_REJECT_BOOKINGS
    )),
    ROLE_CUSTOMER(Arrays.asList(
        RolePermission.SEARCH_TOOLS,
        RolePermission.BOOK_TOOL
    ));
}
```

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

4. **Ejecución**:
   ```bash
   mvn spring-boot:run
   ```

## 📌 Ejemplos de Uso

### Registro de Usuario
```http
POST /customers
Content-Type: application/json

{
  "firstName": "Juan",
  "lastName": "Pérez",
  "email": "juan@ejemplo.com",
  "password": "Cliente123",
  "repeatedPassword": "Cliente123",
  "phone": "5551234567"
}
```

### Autenticación
```http
POST /auth/authenticate
Content-Type: application/json

{
  "username": "juan@ejemplo.com",
  "password": "Cliente123"
}
```

## 🧪 Pruebas

Ejecutar tests con:
```bash
mvn test
```

Cobertura de pruebas:
```bash
mvn jacoco:report
```

## 📈 Roadmap

- [ ] Implementar WebSocket para notificaciones en tiempo real
- [ ] Añadir integración con Stripe/PayPal
- [ ] Implementar caché con Redis
- [ ] Dockerizar la aplicación

## 🤝 Contribuir

1. Haz fork del proyecto
2. Crea tu rama: `git checkout -b feature/nueva-funcionalidad`
3. Haz commit: `git commit -m 'Añade X funcionalidad'`
4. Haz push: `git push origin feature/nueva-funcionalidad`
5. Abre un Pull Request

## 📄 Licencia

MIT © [Adrián Pérez] - **[Contáctame](mailto:tuemail@ejemplo.com)**
```

---



3. **Documenta variables de entorno**:
   ```markdown
   | Variable           | Descripción                          | Valor por defecto |
   |--------------------|--------------------------------------|-------------------|
   | DB_URL             | URL de la base de datos              | localhost:5432    |
   | JWT_SECRET         | Secreto para firmar JWT              | -                 |
   | JWT_EXPIRATION    | Tiempo de expiración del token (ms) | 86400000 (24h)    |
   ```

4. **Añade ejemplos de curl**:
   ```markdown
   ### Ejemplo cURL
   ```bash
   curl -X POST 'http://localhost:8080/auth/authenticate' \
   -H 'Content-Type: application/json' \
   -d '{"username":"admin@construct.com","password":"Admin123"}'
   ```
   ```
