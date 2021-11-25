# Multitienda
 
#### Este proyecto esta realizado con IntelliJ IDEA Ultimate, es aconsejable abrir el proyecto en dicha versión con todas las dependecias actualizadas.
---
### Fotos

![Alt text](https://pbs.twimg.com/media/FE4jGTVWQAUtIqN?format=jpg&name=large) "Modo Día"

![Alt text](https://pbs.twimg.com/media/FE4jJ03XoAMZRlD?format=jpg&name=large) "Login"

![Alt text](https://pbs.twimg.com/media/FE4jHpOXMAMTYZ9?format=jpg&name=large) "Modo noche"

![Alt text](https://pbs.twimg.com/media/FE4jHpOXMAMTYZ9?format=jpg&name=large)
---

## Host de la web
Una de las formas que se me ha ocurrido para optener la URL de la web
es con el SercletUri
```java
    /**
     * Obtiene el host del la web
     * @return URL del host
     */
    public static String host() {
        String host;
        try {
            String currentURL =
                    ServletUriComponentsBuilder.
                            fromCurrentContextPath().
                            build().
                            toUriString();

            host = new URL(currentURL).getHost();

        } catch (MalformedURLException e) {
            host = "none";
        }

        return host;
    }
```


---

## Logs

### La idea principal del los logs sería hacer en un principio un handler interceptor
 * https://www.baeldung.com/spring-mvc-custom-handler-interceptor
 * Pero por el momento vamos a implementar con el http host con la info de la sesión

Para guardar los logs en ficheros he implementado la lectura de ficheros de **NIO 2**. Por lo que me he estado documentado la lecura y la escritura las hacen más rápidas que los buffersReader que se suelen usar generalmente.

Ejmplo:

```java
    /**
     * Crea un fichero vacío si aún no existe
     * @param paths ruta /examples/emptyFile.txt
     */
    public static void createFileIfNotExit(String paths){
        Path emptyFile = Paths.get(paths);
        if (Files.notExists(emptyFile)) {
            try {
                Files.createFile(Paths.get(paths));
            } catch (IOException e) {
                System.out.println("Error a la 
                creacción de archivos");
            }
        }
    }
```
