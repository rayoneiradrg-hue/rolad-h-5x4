# Roland H 5x4 — proyecto Fabric 26.3

Proyecto fuente inicial ampliado. **No es todavía un tractor terminado ni un JAR probado.**
Incluye una entidad de vehículo con controles, estado de motor, freno, luces y cortadora como lógica base.
La compatibilidad de las clases y mappings debe verificarse contra el entorno Fabric 26.3 antes de distribuir.

## Compilar
Requiere Java 25 y Gradle 9.9:
`gradle build`
El JAR se genera en `build/libs/`.

## Controles previstos
W/S acelerar y retroceder; A/D girar; E motor; F cortadora; G freno; L luces; R rango.
