<h1>Payment System API</h1>

The Payment Processing System API is a RESTful web service that allows users to process payments through an API. Users can register, link their credit cards or bank accounts, make payments, and view their payment history.
<h2>Table of Contents:</h2>
<ul>
    <li>Technologies Used</li>
  
  
</ul>

<h2>Technologies Used</h2>
<ul>
    <li>Java</li>
    <li>Spring Boot</li>
    <li>Spring Data JPA</li>
    <li>MySQL</li>
    <li>Spring Security</li>
    <li>Maven</li>
    <li>Swagger</li>
  </ul>
  
  <h2>Features</h2>
  <ul>
    <li>User registration and authentication with JWT</li>
    <li>Linking credit cards or bank accounts to user profiles</li>
    <li>Processing payments through API</li>
    <li>Retrieving payment history</li>
    <li>Error handling and validation</li>
    <li>Secure storage of sensitive data (e.g., passwords)</li>
  </ul>
  
  
  <h2>Getting Started</h2>
  To run the Payment System API locally, follow these steps:
  <ol>
    <li>Clone the repository:</li>
    <p><i>https://github.com/ge0rge97/PaymentSystem.git</i></p>
    <li>Navigate to the project directory:</li>
    <p><i>cd PaymentSystem</i></p>
    <li>Set up the MySQL database and configure the database connection in the application.yaml file.</li>
    </br>
    <li>Build the project using Maven:</li>
    <p><i>mvn clean install</i></p>
    <li>Run the application:</li>
    <p><i>mvn spring-boot:run</i></p>
    <li>The API will be accessible at <b>http://localhost:8080</b></li>
  </ol>

  <h2>API Endpoints</h2>
  <p>The API provides the following endpoints:</p>
  <ul>
    <h3>AUTH</h3>
    <li>' POST <b>/api/v1/auth/register</b> ' - User registration</li>
    <li>' POST <b>/api/v1/auth/login</b> ' - User login</li>
    <li>' POST <b>/api/v1/auth/refresh</b> ' - Refresh user tokens</li>
    <h3>USER</h3>
    <li>' GET <b>/api/v1/users/{id}</b> ' - Get User by Id.</li>
    <li>' GET <b>/api/v1/users/{id}/paymentMethods</b> ' - Get Payment Methods by UserId.</li>
    <li>' GET <b>/api/v1/users/{id}/payments</b> ' - Get Payments by UserId.</li>
    <li>' POST <b>/api/v1/users/{id}/paymentMethods</b> ' - Create Payment Methods for User.</li>
    <li>' POST <b>/api/v1/users/{senderId}/payment/{receiverId}</b> ' - Create Payment.</li>
    <li>' DELETE <b>/api/v1/users/{id}</b> ' - Delete User by Id.</li>
    <h3>PAYMENT METHOD</h3>
    <li>' GET <b>/api/v1/paymentMethods/{id}</b> ' - Get Payment Method by id.</li>
    <li>' DELETE <b>/api/v1/paymentMethods/{id}</b> ' - Delete Payment Method by id.</li>
    <h3>PAYMENT</h3>
    <li>' GET <b>/api/v1/payments/{id}</b> ' - Get Payment by id.</li>
    <li>' DELETE <b>/api/v1/payments/{id}</b> ' - Delete Payment by id.</li>
  </ul>
  <p>For detailed information on each endpoint, refer to the <b><a href="http://localhost:8080/swagger-ui/index.html#/">API documentation</a></b> (based on Swagger).</p>

  <h2>Authentication</h2>
  <p>Authentication for API endpoints is performed using JSON Web Tokens (JWT). Users must register and obtain a JWT token to include in the Authorization header of subsequent API requests.</p>
  
  <h2>Error Handling</h2>
  <p>The API handles errors using appropriate HTTP status codes and provides informative error messages in the response body. Common error scenarios include validation errors, authentication failures, and resource not found.</p>

