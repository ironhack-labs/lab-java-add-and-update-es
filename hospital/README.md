## Respuesta a Preguntas sobre las Rutas de la API

1. **¿Usó el mismo tipo de ruta para actualizar la información del paciente y para actualizar un departamento de empleados?**
   Sí, utilicé el método HTTP `PUT` para ambas actualizaciones. Las rutas son `/api/patients/{id}` para actualizar la información del paciente y `/api/employees/{id}` para actualizar la información del empleado.

2. **¿Por qué eligió la estrategia que eligió?**
   Elegí el método `PUT` porque se utiliza para reemplazar completamente un recurso existente o actualizar partes significativas de él. Esto se ajusta bien a los casos de uso en los que se necesita actualizar varios campos de un objeto.

3. **¿Cuáles son las ventajas e inconvenientes de las estrategias que eligió para crear estas rutas?**
   **Ventajas**:
    - Claridad: Utilizar `PUT` proporciona una semántica clara de que el recurso se está actualizando.
    - Consistencia: Mantiene una estructura uniforme en la API, facilitando su uso.

   **Inconvenientes**:
    - Rigidez: `PUT` requiere que se envíe toda la información del recurso, lo que puede ser ineficiente si solo se actualizan algunos campos.
    - Posibilidad de errores: Si se omiten campos obligatorios, puede causar errores al intentar actualizar el recurso.

4. **¿Cuáles son los compromisos entre PUT y PATCH?**
    - `PUT` es idempotente y se utiliza para reemplazar completamente un recurso, lo que significa que múltiples solicitudes con los mismos datos no deberían cambiar el estado del recurso.
    - `PATCH`, por otro lado, se utiliza para aplicar cambios parciales a un recurso, lo que permite actualizar solo los campos necesarios sin necesidad de enviar toda la representación del recurso.
    - La elección entre `PUT` y `PATCH` depende de la necesidad de realizar actualizaciones completas o parciales y del comportamiento esperado en términos de idempotencia.
