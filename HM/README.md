# HM Project

## Preguntas

### ¿Usó el mismo tipo de ruta para actualizar la información del paciente y para actualizar un departamento de empleados?
No, utilicé `PUT` para actualizar la información del paciente y `PATCH` para actualizar el departamento de empleados.

### ¿Por qué eligió la estrategia que eligió?
Elegí `PUT` para actualizar la información del paciente porque implica la actualización completa del recurso, mientras que `PATCH` se utilizó para el departamento de empleados porque permite actualizaciones parciales del recurso.

### ¿Cuáles son las ventajas e inconvenientes de las estrategias que eligió para crear estas rutas?
**Ventajas:**
- `PUT` asegura que toda la información del paciente esté actualizada y consistente.
- `PATCH` permite cambios parciales sin necesidad de enviar todos los datos del recurso, lo cual es más eficiente para actualizaciones menores.

**Inconvenientes:**
- `PUT` puede ser menos eficiente porque requiere enviar todos los datos del recurso.
- `PATCH` puede ser menos intuitivo para algunos desarrolladores y requiere una lógica adicional para manejar actualizaciones parciales.

### ¿Cuáles son los compromisos entre PUT y PATCH?
**PUT** reemplaza completamente el recurso, lo que puede ser más simple para entender pero menos eficiente para actualizaciones parciales. **PATCH** permite actualizaciones parciales, lo que es más eficiente pero puede requerir una lógica adicional para manejar los cambios parciales correctamente.
