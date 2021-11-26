# Multitienda
 
#### Este proyecto esta realizado con IntelliJ IDEA Ultimate, es aconsejable abrir el proyecto en dicha versión con todas las dependecias actualizadas.
---
### Fotos

![Alt text](https://pbs.twimg.com/media/FE4jGTVWQAUtIqN?format=jpg&name=large) "Modo Día"

![Alt text](https://pbs.twimg.com/media/FE4jJ03XoAMZRlD?format=jpg&name=large) "Login"

![Alt text](https://pbs.twimg.com/media/FE4jHpOXMAMTYZ9?format=jpg&name=large) "Modo noche"

![Alt text](https://i.imgur.com/uJTE1cI.png) "Backend""

---

## Host de la web
Una de las formas que se me ha ocurrido para optener la URL de la web
es con el ServletUri
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

## Dia noche y eventos

### Realmente la idea principal que tenía es realizar el cambio de ccs del fondo con el JS y dejando principalmente para la tomas de datos. Pero al final lo he implementado en el Mapping de la web. Añadiendo en el head: 
`<link rel="stylesheet" th:href="'/css/'${css}'.css'">`

```java
    if (isNavidad.isNavidad()) {
        model.addAttribute("css","navidad");
    } else if (ihora>=22 || ihora <=7) {
        model.addAttribute("css","oscuro");
    }else{
        model.addAttribute("css","style");
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
---

## Productos
Con productos he conseguido que funcionase hasta cierta parte ya que las imagenes no se muestran por culpa del texto el ccs lo diseñe de tal formo que el texto ocupa el espacio de la imagen y  hace que se rompa todo.

```html
<!-- Esta sería la forma correcta de implementar el código complento -->

<article class="product__card" th:each="producto:${productos}">
    <div class="product__circle"></div>

    <img src="http://placehold.it/400x400" alt="" th:src="${#strings.isEmpty(producto.imagen) ? ${producto.imagen} : ''}" class="product__img">

    <h3 class="product__title" th:text="${producto.nombre}">Nombre del producto</h3>

    <span th:class="${producto.descuento==0} ? 'product__price' : 'product__price__discount'" th:text="${#numbers.formatDecimal(producto.pvp,1,'POINT',2,'COMMA')+'€'}">...</span>

    <span th:class="${producto.descuento==0} ? 'hide product__price' : ''" th:text="${#numbers.formatDecimal(producto.pvp-producto.pvp*producto.descuento,1,'POINT',2,'COMMA')+'€'}">...</span>

    <button class="button--flex product__button">
        <i class="ri-shopping-bag-line"></i>
    </button>

</article>

```
```html
<!-- Forma que he conseguido que se muestre -->
<article class="product__card" th:each="producto:${productos}">

    <!-- Como se puede observar hago una prueba con una imagen static y no llega a mostrase ya que en 
    su lugar esta el nombre entero del producto -->
    <img src="assets/img/product1.png" alt="" class="product__img">

    <h3 class="product__title" th:text="${producto.nombre}">Nombre del producto</h3>
    <span class="product__price">$19.99</span>

    <button class="button--flex product__button">
        <i class="ri-shopping-bag-line"></i>
    </button>

</article>
```

![Alt text](https://i.imgur.com/Hv5lBzn.png) "Productos"


