

## ¿Usó el mismo tipo de ruta para actualizar la información del paciente y para actualizar un departamento de empleados?
 usé el método PUT y PATCH.

## ¿Por qué eligió la estrategia que eligió?
Elegí PUT porque es fácil de usar para actualizar datos completos.

## ¿Cuáles son las ventajas e inconvenientes de las estrategias que eligió para crear estas rutas?
### Ventajas:
- **Consistencia:** Es fácil de entender.
- **Simplicidad:** PUT es sencillo de implementar.

### Inconvenientes:
- **Ineficiencia:** Puede enviar datos innecesarios.
- **No parcial:** No es bueno para cambios pequeños.

## ¿Cuáles son los compromisos entre PUT y PATCH?
- **PUT:** Actualiza todo el recurso, fácil pero puede ser ineficiente.
- **PATCH:** Actualiza solo partes del recurso, eficiente pero más complicado.
