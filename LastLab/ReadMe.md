# Hospital Management API

## Actualización de Información

1. **¿Usó el mismo tipo de ruta para actualizar la información del paciente y para actualizar un departamento de empleados?**

   Sí, utilicé el método HTTP PUT para ambas acciones.

2. **¿Por qué eligió la estrategia que eligió?**

   Elegí usar PUT porque cada actualización implica reemplazar completamente los valores existentes con los proporcionados. PUT es ideal cuando se desea enviar una representación completa del recurso que se actualizará.

3. **¿Cuáles son las ventajas e inconvenientes de las estrategias que eligió para crear estas rutas?**

   - **Ventajas:**
     - Simplicidad: Usar PUT ayuda a mantener consistencia en el uso del método HTTP para operaciones de actualización completas.
     - Claridad: PUT indica claramente la intención de reemplazar el recurso completo.

   - **Inconvenientes:**
     - Mayor carga de datos: En operaciones parciales, enviar toda la representación puede implicar enviar más datos de los necesarios.
     - Menos semántica para actualizaciones parciales: PUT podría no ser la elección más precisa para actualizaciones parciales, donde PATCH puede ser más adecuado.

4. **¿Cuáles son los compromisos entre PUT y PATCH?**

   - **PUT**: Se utiliza para actualizaciones completas. Reemplaza toda la entidad con los datos proporcionados. Es más simple implementar cuando se espera siempre una representación completa, pero puede implicar más carga de datos.
   
   - **PATCH**: Se usa para actualizaciones parciales. Modifica solo los campos especificados. Es eficiente y apta para cambios pequeños, evitando el envío de datos innecesarios. Sin embargo, puede requerir una lógica adicional para manejar las actualizaciones parciales correctamente.