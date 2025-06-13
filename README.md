
# 🧩 Spring Kafka Event-Driven App

Este proyecto es una prueba de concepto de comunicación basada en eventos utilizando **Spring Boot**, **Apache Kafka**, y arquitectura de microservicios. Incluye dos microservicios:

- `payments-api`: produce eventos de pagos confirmados.
- `orders-api`: consume esos eventos y persiste órdenes.

---

## 🧱 Arquitectura

```plaintext
[payments-api] --(Kafka Topic: payment)--> [orders-api]
```

- Comunicación asincrónica usando Kafka.
- Persistencia en base de datos H2.
- Visualización de mensajes con Kafka UI.

---

## 🚀 Tecnologías Usadas

- Java 21 + Spring Boot 3.5
- Apache Kafka + Zookeeper
- Docker + Docker Compose
- Spring Data JPA + H2 DB
- Spring Kafka
- Kafka UI

---

## 📂 Estructura de carpetas

```
spring-kafka-event-driven/
├── payments-api/
├── orders-api/
├── docker-compose.yml
└── README.md
```

---

## 🐳 Instrucciones para correr el proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/MaximilianoTRZ/spring-kafka-event-driven.git
cd spring-kafka-event-driven
```

### 2. Levantar Kafka, Zookeeper y Kafka UI

```bash
docker-compose up -d
```

> Esperá unos segundos hasta que los servicios estén listos.

Accedé a Kafka UI en: [http://localhost:8080](http://localhost:8080)

---

### 3. Correr los microservicios

Desde dos terminales distintas:

```bash
cd payments-api
./mvnw spring-boot:run
```

```bash
cd orders-api
./mvnw spring-boot:run
```

---

## 🔁 Flujo del evento

1. Se realiza un `POST /api/payments` en `payments-api`.
2. Este microservicio produce un evento al topic `payment`.
3. `orders-api` escucha ese topic y persiste la orden.
4. Podés consultar las órdenes con: `GET /api/orders`.

---

## 📬 Endpoints REST

### `payments-api`
| Método | URL                | Descripción             |
|--------|--------------------|-------------------------|
| POST   | `/api/payments`    | Envía un pago (produce Kafka) |

### `orders-api`
| Método | URL                | Descripción             |
|--------|--------------------|-------------------------|
| GET    | `/api/orders`      | Obtiene todas las órdenes recibidas |

---

## 📊 Visualización

Podés usar Kafka UI en `http://localhost:8080` para:

- Ver los topics
- Ver los consumidores activos
- Explorar los mensajes enviados

---

## 🛠 Tips de Troubleshooting

- Si ves `CoordinatorNotAvailableException`:
  - Asegurate que Zookeeper haya arrancado correctamente **antes** que Kafka.
  - Esperá unos segundos tras levantar los servicios antes de iniciar los microservicios.
- Para limpiar todo el entorno:

```bash
docker-compose down -v
docker system prune -af
```

---

## 📌 Pendientes / Ideas

- Agregar paginación a `/api/orders`.
- Agregar tests unitarios y de integración.
- Implementar retries y manejo de errores.
- Desplegar en AWS usando Terraform.

---

## 📜 Licencia

MIT © [MaximilianoTRZ](https://github.com/MaximilianoTRZ)
