# Hospital Database Management API

1. ¿Usó el mismo tipo de ruta para actualizar la información del paciente y para actualizar un departamento de empleados?
    - No, usé `PATCH` for actualizar campos específicos Como like department and status para `Employee` y `PUT` para acualizaciones completes en `Patient`.

2. ¿Por qué eligió la estrategia que eligió?
     - Usé `PATCH` porque permite actualizaciones parciales, lo que es eficiente para cambios específicos, mientras que 'PUT' ‘Patient` permite actualizaciones completas cuando cambia la información del paciente.

3. ¿Cuáles son las ventajas e inconvenientes de las estrategias que eligió para crear estas rutas?
 **PATCH** es eficiente para actualizaciones de campos específicos, pero puede requerir una validación adicional. 
 **PUT** es consistente con actualizaciones completas, pero requiere los datos completos del objeto, lo que podría aumentar el tamaño de payload

4. ¿Cuáles son los compromisos entre PUT y PATCH?

 'PUT' es más sencillo, “to the point” pero menos eficiente para actualizaciones parciales.
 'PATCH' es liviano pero aporta complejidad para manejar cada campo.