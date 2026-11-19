# Gremio de Aventureros – D&D 5e

Aplicación de escritorio en Java para **Wizards of the Coast** que registra héroes y simula sus tácticas de combate según las reglas de *Calabozos y Dragones 5ª Edición*.

## Funcionalidades

| Requerimiento | Descripción |
|---|---|
| RF1 – Registro | Registra Guerreros, Magos, Clérigos y Pícaros con nombre, nivel (1-20), puntos de vida y su atributo especial |
| RF2 – Gremio | Tabla con todos los aventureros registrados |
| RF3 – Combate | Cada aventurero ejecuta su táctica de forma polimórfica (`realizarAccion()`) |
| RF4 – Historial | Cada registro y combate se anexa en `registro_gremio.txt` |
| Reportes | Composición del gremio y estadísticas (mayor nivel, más PV, nivel promedio) |

## Arquitectura (MVC)

```
src/main/java
├── gremiodnd/     Main (punto de entrada y reportes en consola)
├── modelo/        IAccionCombate, Aventurero (abstract), Guerrero, Mago, Clerigo, Picaro, DatosInvalidosException
├── vista/         FrmGremio (JFrame Form diseñado con el editor visual de NetBeans)
├── controlador/   ControladorGremio
└── persistencia/  GestorArchivo
src/test/java/modelo   Pruebas JUnit 5
docs/                  Diagramas UML y de flujo (draw.io)
```

## Conceptos de POO aplicados

- **Clase abstracta:** `Aventurero`
- **Interfaz:** `IAccionCombate`
- **Herencia con `super`:** las 4 clases hijas
- **Polimorfismo / sobreescritura:** `realizarAccion()`, `getDadoGolpe()`, `getAtributoEspecial()`
- **Sobrecarga:** `Mago.gastarEspacioConjuro()` y `Mago.gastarEspacioConjuro(int)`
- **static / final:** `NIVEL_MINIMO`, `NIVEL_MAXIMO`, `totalAventureros`, `RUTA_ARCHIVO`
- **Excepción propia:** `DatosInvalidosException`

## Cómo ejecutar

1. Abrir el proyecto en Apache NetBeans (proyecto Maven, JDK 17 o superior).
2. **Run Project (F6)** para abrir la aplicación.
3. **Test Project (Alt+F6)** para ejecutar las pruebas JUnit.
