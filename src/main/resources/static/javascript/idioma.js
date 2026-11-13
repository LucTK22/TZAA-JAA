/* Selector y traducción de la interfaz pública; conserva los nombres y datos de cada perfume. */
(() => {
    const traducciones = {
        en: {
            "inicio": "HOME", "perfumes": "FRAGRANCES", "registrarme": "CREATE ACCOUNT", "identificarme": "SIGN IN", "buscar perfume": "Search fragrance",
            "carrito": "BAG", "mis pedidos": "MY ORDERS", "mis datos": "MY DETAILS", "cerrar sesión": "SIGN OUT",
            "usuario no identificado": "Guest", "admin": "ADMIN", "perfumería de autor": "NICHE PERFUMERY",
            "volver a la tienda": "BACK TO STORE", "tzaa jaa! · perfumería selecta": "TZAA JAA! · NICHE PERFUMERY",
            "un aroma.una huella.": "A SCENT.A LASTING IMPRESSION.", "un aroma.": "A SCENT  .", "una huella.": "A LASTING IMPRESSION.",
            "fragancias con carácter, elegidas para dejar recuerdo.": "Distinctive fragrances, chosen to leave a lasting impression.",
            "descubrir perfumes": "DISCOVER FRAGRANCES", "descubrir mi esencia": "DISCOVER MY SCENT",
            "ver perfume": "VIEW FRAGRANCE", "añadir al carrito": "ADD TO BAG", "cantidad": "Quantity",
            "mi carrito": "MY BAG", "un aroma extraordinario, un paso más cerca de ti.": "An extraordinary scent, one step closer.",
            "productos": "Items", "precio": "Price", "subtotal": "Subtotal", "eliminar": "Remove",
            "seguir comprando": "CONTINUE SHOPPING", "vaciar carrito": "EMPTY BAG", "resumen del pedido": "ORDER SUMMARY",
            "envío": "Delivery", "gratis": "Free", "total": "TOTAL", "continuar compra": "PROCEED TO CHECKOUT",
            "pago seguro": "Secure payment", "envío gratuito en pedidos superiores a 80 €": "Free delivery on orders over €80",
            "devoluciones fáciles hasta 30 días": "Easy returns within 30 days", "más que perfumes,": "MORE THAN FRAGRANCE,",
            "experiencias": "AN EXPERIENCE", "encuentra la esencia que habla de ti.": "Find the scent that speaks to you.",
            "crear una cuenta": "Create an account", "regístrate para disfrutar de nuestra tienda de perfumes.": "Create an account to enjoy our fragrance collection.",
            "nombre:": "First name:", "apellidos:": "Last name:", "correo electrónico:": "Email address:", "teléfono:": "Phone:",
            "contraseña:": "Password:", "correo electrónico": "Email address", "tu correo electrónico": "Your email address",
            "tu contraseña": "Your password", "identificarme": "SIGN IN", "accede a tu cuenta para añadir perfumes al carrito.": "Sign in to add fragrances to your bag.",
            "finalizar compra": "CHECKOUT", "finalizar compra — paso 2": "CHECKOUT — STEP 2", "finalizar compra — paso 3": "CHECKOUT — STEP 3",
            "datos de envío": "Delivery details", "datos de pago": "Payment details", "un detalle para tu compra": "A personal touch",
            "envío": "Delivery", "pago": "Payment", "regalo": "Gift", "resumen": "Summary", "nombre completo": "Full name",
            "dirección": "Address", "provincia": "Region", "localidad": "City", "código postal": "Postal code",
            "continuar": "CONTINUE", "volver a la tienda": "BACK TO STORE", "tipo de tarjeta": "Card type",
            "selecciona una tarjeta": "Choose a card", "número de tarjeta": "Card number", "titular de la tarjeta": "Name on card",
            "escribe los números que aparecen en el frontal de tu tarjeta.": "Enter the numbers shown on the front of your card.",
            "indica el nombre impreso en la tarjeta.": "Enter the name printed on the card.", "fecha de caducidad": "Expiry date",
            "mes": "Month", "año": "Year", "enero": "January", "febrero": "February", "marzo": "March", "abril": "April",
            "mayo": "May", "junio": "June", "julio": "July", "agosto": "August", "septiembre": "September",
            "octubre": "October", "noviembre": "November", "diciembre": "December", "¿es un regalo?": "Is this a gift?",
            "selecciona una opción": "Choose an option", "sí, es para regalo": "Yes, it is a gift", "no": "No",
            "resumen del pedido": "ORDER SUMMARY", "productos": "Items", "volver": "BACK", "confirmar pedido": "PLACE ORDER",
            "¡compra confirmada!": "ORDER CONFIRMED!", "el carrito está vacío.": "Your bag is empty.",
            "la esencia": "The essence", "género": "Gender", "mililitros": "Volume", "categoría": "Category",
            "unisex": "Unisex", "volver a perfumes": "← BACK TO FRAGRANCES", "best seller": "BEST SELLER",
            "tzaa jaa! · descubrimiento olfativo": "TZAA JAA! · SCENT DISCOVERY", "scent finder": "SCENT FINDER",
            "cinco preguntas para encontrar la fragancia que encaja contigo.": "Five questions to find the fragrance that feels like you.",
            "comenzar": "BEGIN", "tu perfil olfativo": "YOUR SCENT PROFILE", "tu selección · nuestra recomendación": "YOUR SELECTION · OUR RECOMMENDATION",
            "tu huella olfativa": "YOUR SCENT SIGNATURE", "selecciona una respuesta para continuar.": "Choose an answer to continue.",
            "← revisar respuestas": "← REVIEW ANSWERS", "volver a empezar": "START AGAIN", "ver perfumes →": "VIEW FRAGRANCES →",
            "continuar →": "CONTINUE →", "← anterior": "← BACK", "←": "←", "para mí": "For me",
            "quiero encontrar mi próxima fragancia.": "I want to find my next fragrance.", "para ella": "For her", "para él": "For him",
            "unisex": "Unisex", "¿para quién buscas el perfume?": "Who are you looking for a fragrance for?",
            "la mayoría de nuestra colección es unisex; esta respuesta orienta la selección sin excluir esas fragancias.": "Most of our collection is unisex; your answer guides the selection without excluding those fragrances.",
            "¿qué familia olfativa te atrae más?": "Which fragrance family appeals to you most?",
            "elige la que más te apetece llevar, aunque no conozcas todas sus notas.": "Choose the one you feel like wearing most, even if you do not know all its notes.",
            "ámbar y cálida": "Amber and warm", "dorada, envolvente y con un punto dulce.": "Golden, enveloping, with a touch of sweetness.",
            "floral": "Floral", "elegante, luminosa y con carácter.": "Elegant, bright and distinctive.", "maderas y oud": "Woods and oud",
            "profunda, sofisticada y misteriosa.": "Deep, sophisticated and mysterious.", "dulce y almizclada": "Sweet and musky",
            "suave, sensual y reconfortante.": "Soft, sensual and comforting.", "¿qué sensación quieres transmitir?": "What feeling do you want to evoke?",
            "piensa en cómo quieres sentirte cuando lleves el perfume.": "Think about how you want to feel when wearing the fragrance.",
            "luminosa y elegante": "Radiant and elegant", "una presencia refinada que se hace notar.": "A refined presence that stands out.",
            "cálida y acogedora": "Warm and inviting", "una fragancia que envuelve como un abrazo.": "A fragrance that wraps around you like an embrace.",
            "sensual": "Sensual", "un aroma íntimo, seductor y memorable.": "An intimate, alluring and memorable scent.", "misteriosa": "Mysterious",
            "profundidad, contraste y mucha personalidad.": "Depth, contrast and plenty of personality.", "¿qué intensidad prefieres?": "What intensity do you prefer?",
            "no hay una opción mejor: depende de la presencia que te guste.": "There is no right answer; it depends on the presence you enjoy.",
            "suave": "Soft", "cercana y discreta.": "Close and discreet.", "equilibrada": "Balanced", "se percibe sin dominar el espacio.": "Noticeable without taking over the room.",
            "intensa": "Intense", "con una estela que deja recuerdo.": "With a trail that leaves a lasting impression.", "¿cuándo lo usarías más?": "When would you wear it most?",
            "así podemos priorizar perfumes que encajen con tu día a día.": "This helps us prioritise fragrances that suit your routine.",
            "en el día a día": "Every day", "para acompañarme a menudo.": "A scent to wear often.", "por la noche": "At night", "para planes y momentos especiales.": "For plans and special moments.",
            "en ocasiones especiales": "On special occasions", "quiero reservarlo para ocasiones únicas.": "I want to save it for exceptional occasions.",
            "un poco para todo": "A little of everything", "busco mi fragancia de cabecera.": "I am looking for my signature fragrance.",
            "estamos buscando tus coincidencias…": "Finding your matches…", "no hay perfumes disponibles para recomendar.": "There are no fragrances available to recommend.",
            "no hemos podido cargar el catálogo ahora. comprueba que la tienda esté abierta e inténtalo de nuevo.": "We could not load the collection. Check that the store is available and try again.",
            "pregunta anterior": "Previous question", "coincidencia": "MATCH",
            "identificado correctamente. ya puedes añadir perfumes al carrito.": "Signed in. You can now add fragrances to your bag.",
            "identifícate primero para añadir perfumes al carrito.": "Please sign in before adding fragrances to your bag.",
            "identifícate para consultar tu carrito.": "Please sign in to view your bag.", "introduce una cantidad válida, como mínimo 1.": "Enter a valid quantity of at least 1.",
            "no se ha podido identificar el usuario.": "Could not sign in.", "no se ha podido añadir el perfume al carrito.": "Could not add the fragrance to your bag.",
            "rellena todos los datos de envío.": "Complete all delivery details.", "introduce un correo electrónico válido.": "Enter a valid email address.",
            "rellena todos los datos de la tarjeta.": "Complete all card details.", "la fecha de caducidad de la tarjeta ya ha pasado.": "This card has expired.",
            "indica si el pedido es para regalo.": "Please tell us whether this order is a gift.", "no se ha podido cargar el resumen del pedido.": "Could not load the order summary.",
            "error al cargar el paso 2.": "Could not load step 2.", "error al cargar la pregunta sobre el regalo.": "Could not load the gift question.",
            "error al cargar el resumen.": "Could not load the summary.", "error al registrar el usuario": "Could not register the account.",
            "no se ha podido cargar la pantalla de compra.": "Could not load checkout.", "no se ha podido guardar los datos de envío.": "Could not save delivery details.",
            "no se han podido guardar los datos de pago.": "Could not save payment details.", "no se ha podido confirmar el pedido.": "Could not confirm the order.",
            "no se ha podido cargar el carrito.": "Could not load your bag.", "no se ha podido eliminar el perfume.": "Could not remove the fragrance.",
            "no se ha podido actualizar la cantidad.": "Could not update the quantity.", "no se ha podido vaciar el carrito.": "Could not empty your bag.",
            "bienvenido a la administración de la tienda": "Welcome to the store administration",
            "gestionar perfumes": "MANAGE FRAGRANCES", "gestionar pedidos": "MANAGE ORDERS", "gestionar categorías": "MANAGE CATEGORIES",
            "tzaa jaa! · perfumería de autor": "TZAA JAA! · NICHE PERFUMERY", "la colección, cuidada hasta el último detalle.": "The collection, curated down to the last detail.",
            "buscar en la colección": "Search the collection", "nombre o marca": "Name or brand", "perfume en la colección": "fragrance in the collection",
            "perfumes en la colección": "fragrances in the collection", "+ añadir perfume": "+ Add fragrance", "editar ficha": "Edit details",
            "no hay perfumes que coincidan": "No fragrances match your search", "prueba con otro nombre o marca para encontrar una fragancia.": "Try another name or brand to find a fragrance.",
            "gestionar usuarios": "MANAGE USERS", "registrar perfume": "ADD FRAGRANCE", "volver a la tienda": "BACK TO STORE",
            "editor de colección": "COLLECTION EDITOR", "ajusta la ficha y conserva la esencia de cada fragancia.": "Refine the product details while preserving each fragrance’s character.",
            "volver a perfumes": "Back to fragrances", "vista de catálogo": "CATALOG PREVIEW", "la imagen actual se conserva si no seleccionas una fotografía nueva.": "The current image will be kept unless you choose a new one.",
            "información de la fragancia": "Fragrance details", "datos que se muestran en la tienda.": "Details shown in the store.", "género o estilo": "Gender or style", "familia olfativa": "Fragrance family",
            "fotografía del frasco": "Bottle photograph", "imagen principal que aparece en el catálogo.": "Main image shown in the catalogue.", "fondo de la ficha": "Product page background", "fondo editorial opcional al abrir la fragancia.": "Optional editorial background shown when opening the fragrance.",
            "administración · perfumería": "ADMINISTRATION · PERFUMERY", "gestión de categorías": "Category management",
            "organiza las categorías de perfumes de tu tienda.": "Organise the fragrance categories in your store.", "+ nueva categoría": "+ New category",
            "nombre": "Name", "descripción": "Description", "acciones": "Actions", "editar": "Edit", "eliminar": "Delete",
            "todavía no hay categorías registradas.": "No categories have been registered yet.", "crear categoría": "Create category",
            "editar categoría": "Edit category", "nombre:": "Name:", "descripción:": "Description:", "guardar categoría": "Save category",
            "volver a categorías": "Back to categories", "editar perfume": "Edit fragrance", "editar perfume": "Edit fragrance",
            "género": "Gender", "precio": "Price", "mililitros": "Millilitres", "categoría": "Category", "foto nueva": "New photo",
            "imagen de fondo de la ficha (opcional)": "Product page background image (optional)",
            "si no seleccionas otra, se conserva el fondo actual.": "If you do not choose another image, the current background will be kept.",
            "guardar cambios": "SAVE CHANGES", "volver": "BACK", "pedidos": "Orders",
            "consulta las compras y revisa sus productos y datos de entrega.": "Review purchases, products and delivery details.",
            "← volver al panel": "← Back to dashboard", "pedido": "ORDER", "fecha pendiente": "Date pending",
            "ver detalles": "View details", "aún no hay pedidos": "There are no orders yet",
            "cuando se confirme una compra, aparecerá aquí.": "Confirmed purchases will appear here.",
            "vista actualizada · 29/10/2026 · 13:05 (hora peninsular)": "View updated · 29/10/2026 · 13:05 (Madrid time)",
            "gestionar perfumes": "MANAGE FRAGRANCES", "perfume": "Fragrance", "borrar": "DELETE", "editar": "EDIT",
            "¿estas seguro?": "Are you sure?", "gestionar usuarios": "MANAGE USERS", "esta sección todavía no está implementada.": "This section has not been implemented yet.",
            "login administrador": "Administrator sign in", "login administrador": "ADMINISTRATOR SIGN IN", "contraseña:": "Password:", "entrar": "SIGN IN",
            "detalle del pedido | tzaa jaa!": "Order details | TZAA JAA!", "tzaa jaa! · detalle de compra": "TZAA JAA! · ORDER DETAILS",
            "volver a pedidos": "← Back to orders", "estado del pedido": "Order status", "01 · entrega": "01 · DELIVERY",
            "datos del cliente": "Customer details", "dirección": "Address", "provincia": "Region", "código postal": "Postcode",
            "02 · pago": "02 · PAYMENT", "datos de pago": "Payment details", "titular": "Cardholder", "tarjeta": "Card", "terminada en": "Ending in",
            "no disponible": "Not available", "por seguridad, aquí solo se muestran los últimos cuatro dígitos.": "For security, only the last four digits are shown here.",
            "03 · artículos": "03 · ITEMS", "perfumes del pedido": "Fragrances in this order", "artículos": "items", "cantidad:": "Quantity:",
            "este pedido todavía no tiene productos confirmados.": "This order has no confirmed products yet.", "total del pedido": "Order total",
            "← volver a todos los pedidos": "← Back to all orders", "perfume registrado": "Fragrance registered", "perfume registrado correctamente": "FRAGRANCE REGISTERED SUCCESSFULLY",
            "ver perfumes": "VIEW FRAGRANCES", "registrar otro": "ADD ANOTHER", "añade una nueva fragancia a la colección de tu tienda.": "Add a new fragrance to your store collection.",
            "información del perfume": "Fragrance information", "introduce los datos de la fragancia.": "Enter the fragrance details.", "nombre del perfume": "Fragrance name",
            "ej. sauvage": "e.g. Sauvage", "ej. dior": "e.g. Dior", "introduce el género": "Enter the gender", "contenido (ml)": "Volume (ml)",
            "ej. 79.99": "e.g. 79.99", "ej. 100": "e.g. 100", "describe las características de la fragancia...": "Describe the fragrance...",
            "fotografía del perfume": "Fragrance photo", "selecciona una imagen desde tu dispositivo.": "Choose an image from your device.",
            "imagen de fondo para la ficha (opcional)": "Product page background image (optional)", "se mostrará a pantalla completa al abrir este perfume.": "It will fill the screen when this fragrance is opened.",
            "cancelar": "Cancel", "guardar perfume →": "SAVE FRAGRANCE →", "perfumería · colección exclusiva": "PERFUMERY · EXCLUSIVE COLLECTION",
            "formulario de usuario": "User form", "← volver a usuarios": "← Back to users", "gestiona los datos de la cuenta del usuario.": "Manage the user's account details.",
            "correo electrónico": "Email address", "apellidos": "Surname", "teléfono": "Phone", "guardar cambios": "Save changes",
            "gestión de usuarios | perfumería": "User management | Perfumery", "gestión de usuarios": "User management",
            "consulta y administra los usuarios de tu tienda.": "View and manage your store users.", "+ nuevo usuario": "+ New user", "email": "Email",
            "todavía no hay usuarios registrados.": "No users have been registered yet.", "¿seguro que quieres eliminar esta categoría?": "Are you sure you want to delete this category?",
            "¿seguro que quieres eliminar este usuario?": "Are you sure you want to delete this user?", "crear usuario": "Create user", "editar usuario": "Edit user",
            "gestión de categorías | perfumería": "Category management | Perfumery", "formulario de categoría": "Category form",
            "pendiente": "Pending", "en preparación": "Preparing", "enviado": "Shipped", "entregado": "Delivered",
            "return confirm('¿estas seguro?')": "return confirm('Are you sure?')",
            "return confirm('¿seguro que quieres eliminar esta categoría?')": "return confirm('Are you sure you want to delete this category?')",
            "return confirm('¿seguro que quieres eliminar este usuario?')": "return confirm('Are you sure you want to delete this user?')"
        },
        ja: {
            "inicio": "ホーム", "perfumes": "香水", "registrarme": "会員登録", "identificarme": "ログイン", "buscar perfume": "香水を検索", "carrito": "カート",
            "mis pedidos": "注文履歴", "mis datos": "登録情報", "cerrar sesión": "ログアウト", "usuario no identificado": "ゲスト",
            "admin": "管理", "perfumería de autor": "ニッチフレグランス", "volver a la tienda": "ショップに戻る",
            "tzaa jaa! · perfumería selecta": "TZAA JAA! · 厳選フレグランス", "un aroma.una huella.": "香りが、記憶になる。", "un aroma.": "香りが、", "una huella.": "記憶になる。",
            "fragancias con carácter, elegidas para dejar recuerdo.": "記憶に残る、個性豊かな香り。", "descubrir perfumes": "香水を見る",
            "descubrir mi esencia": "自分の香りを見つける", "ver perfume": "香水を見る", "añadir al carrito": "カートに追加", "cantidad": "数量",
            "mi carrito": "カート", "un aroma extraordinario, un paso más cerca de ti.": "特別な香りを、あなたのもとへ。", "productos": "商品",
            "precio": "価格", "subtotal": "小計", "eliminar": "削除", "seguir comprando": "買い物を続ける", "vaciar carrito": "カートを空にする",
            "resumen del pedido": "ご注文内容", "envío": "配送", "gratis": "無料", "total": "合計", "continuar compra": "購入手続きへ",
            "pago seguro": "安全なお支払い", "envío gratuito en pedidos superiores a 80 €": "80 €以上のご注文は送料無料",
            "devoluciones fáciles hasta 30 días": "30日以内の簡単返品", "más que perfumes,": "香水を超えた、", "experiencias": "体験を。",
            "encuentra la esencia que habla de ti.": "あなたらしさを語る香りを見つけて。", "crear una cuenta": "アカウントを作成",
            "regístrate para disfrutar de nuestra tienda de perfumes.": "アカウントを作成して香水コレクションをお楽しみください。",
            "nombre:": "名：", "apellidos:": "姓：", "correo electrónico:": "メールアドレス：", "teléfono:": "電話番号：", "contraseña:": "パスワード：",
            "correo electrónico": "メールアドレス", "tu correo electrónico": "メールアドレス", "tu contraseña": "パスワード",
            "accede a tu cuenta para añadir perfumes al carrito.": "ログインして香水をカートに追加してください。", "finalizar compra": "購入手続き",
            "finalizar compra — paso 2": "購入手続き — 2", "finalizar compra — paso 3": "購入手続き — 3", "datos de envío": "配送先情報",
            "datos de pago": "お支払い情報", "un detalle para tu compra": "ギフトについて", "envío": "配送", "pago": "支払い", "regalo": "ギフト", "resumen": "確認",
            "nombre completo": "氏名", "dirección": "住所", "provincia": "都道府県", "localidad": "市区町村", "código postal": "郵便番号",
            "continuar": "続ける", "tipo de tarjeta": "カードの種類", "selecciona una tarjeta": "カードを選択", "número de tarjeta": "カード番号",
            "titular de la tarjeta": "カード名義", "escribe los números que aparecen en el frontal de tu tarjeta.": "カード表面の番号を入力してください。",
            "indica el nombre impreso en la tarjeta.": "カードに記載された氏名を入力してください。", "fecha de caducidad": "有効期限", "mes": "月", "año": "年",
            "enero": "1月", "febrero": "2月", "marzo": "3月", "abril": "4月", "mayo": "5月", "junio": "6月", "julio": "7月", "agosto": "8月",
            "septiembre": "9月", "octubre": "10月", "noviembre": "11月", "diciembre": "12月", "¿es un regalo?": "ギフトですか？",
            "selecciona una opción": "選択してください", "sí, es para regalo": "はい、ギフトです", "no": "いいえ", "volver": "戻る", "confirmar pedido": "注文を確定",
            "¡compra confirmada!": "ご注文が確定しました！", "la esencia": "香りの特徴", "género": "タイプ", "mililitros": "容量", "categoría": "カテゴリー",
            "unisex": "ユニセックス", "volver a perfumes": "← 香水一覧に戻る", "best seller": "人気商品", "tzaa jaa! · descubrimiento olfativo": "TZAA JAA! · 香りの発見",
            "scent finder": "香りを見つける", "cinco preguntas para encontrar la fragancia que encaja contigo.": "5つの質問で、あなたに合う香りを見つけましょう。",
            "comenzar": "始める", "tu perfil olfativo": "あなたの香りのプロフィール", "tu selección · nuestra recomendación": "あなたへのおすすめ",
            "tu huella olfativa": "あなただけの香り", "selecciona una respuesta para continuar.": "回答を選択してください。", "← revisar respuestas": "← 回答を確認",
            "volver a empezar": "最初からやり直す", "ver perfumes →": "香水を見る →", "continuar →": "続ける →", "← anterior": "← 戻る", "←": "←",
            "para mí": "自分用", "quiero encontrar mi próxima fragancia.": "次のお気に入りを見つけたい。", "para ella": "女性へのギフト", "para él": "男性へのギフト",
            "¿para quién buscas el perfume?": "誰のための香水をお探しですか？", "la mayoría de nuestra colección es unisex; esta respuesta orienta la selección sin excluir esas fragancias.": "コレクションの多くはユニセックスです。この回答を参考にしつつ、幅広くご提案します。",
            "¿qué familia olfativa te atrae más?": "どんな香りの系統がお好きですか？", "elige la que más te apetece llevar, aunque no conozcas todas sus notas.": "香料に詳しくなくても、気になるものを選んでください。",
            "ámbar y cálida": "アンバー・温かみ", "dorada, envolvente y con un punto dulce.": "包み込むような、ほのかに甘い香り。", "floral": "フローラル", "elegante, luminosa y con carácter.": "華やかで個性のある香り。",
            "maderas y oud": "ウッド・ウード", "profunda, sofisticada y misteriosa.": "深みのある、洗練された香り。", "dulce y almizclada": "甘くムスキー", "suave, sensual y reconfortante.": "柔らかく心地よい香り。",
            "¿qué sensación quieres transmitir?": "どんな印象をまといたいですか？", "piensa en cómo quieres sentirte cuando lleves el perfume.": "香水をつけたときの気分を想像してください。",
            "luminosa y elegante": "明るくエレガント", "una presencia refinada que se hace notar.": "洗練された存在感。", "cálida y acogedora": "温かく包み込む", "una fragancia que envuelve como un abrazo.": "抱きしめられるような香り。",
            "sensual": "センシュアル", "un aroma íntimo, seductor y memorable.": "親密で魅惑的な香り。", "misteriosa": "ミステリアス", "profundidad, contraste y mucha personalidad.": "深みと個性を感じる香り。",
            "¿qué intensidad prefieres?": "お好みの香りの強さは？", "no hay una opción mejor: depende de la presencia que te guste.": "正解はありません。お好みの強さを選んでください。",
            "suave": "控えめ", "cercana y discreta.": "さりげなく香る。", "equilibrada": "バランス", "se percibe sin dominar el espacio.": "ほどよく印象に残る。", "intensa": "しっかり", "con una estela que deja recuerdo.": "余韻を残す香り。",
            "¿cuándo lo usarías más?": "どんな時に使いたいですか？", "así podemos priorizar perfumes que encajen con tu día a día.": "日々の暮らしに合う香りをご提案します。",
            "en el día a día": "毎日", "para acompañarme a menudo.": "日常に寄り添う香り。", "por la noche": "夜", "para planes y momentos especiales.": "特別な夜に。",
            "en ocasiones especiales": "特別な日", "quiero reservarlo para ocasiones únicas.": "大切な日に楽しみたい。", "un poco para todo": "どんな時にも", "busco mi fragancia de cabecera.": "いつも使える香りを探しています。",
            "estamos buscando tus coincidencias…": "おすすめを探しています…", "no hay perfumes disponibles para recomendar.": "おすすめできる香水がありません。",
            "no hemos podido cargar el catálogo ahora. comprueba que la tienda esté abierta e inténtalo de nuevo.": "商品一覧を読み込めませんでした。ショップを確認してもう一度お試しください。",
            "pregunta anterior": "前の質問", "identificado correctamente. ya puedes añadir perfumes al carrito.": "ログインしました。香水をカートに追加できます。",
            "identifícate primero para añadir perfumes al carrito.": "香水を追加するにはログインしてください。", "identifícate para consultar tu carrito.": "カートを見るにはログインしてください。",
            "introduce una cantidad válida, como mínimo 1.": "1以上の数量を入力してください。", "no se ha podido identificar el usuario.": "ログインできませんでした。",
            "no se ha podido añadir el perfume al carrito.": "香水をカートに追加できませんでした。", "rellena todos los datos de envío.": "配送先情報をすべて入力してください。",
            "introduce un correo electrónico válido.": "有効なメールアドレスを入力してください。", "rellena todos los datos de la tarjeta.": "カード情報をすべて入力してください。",
            "la fecha de caducidad de la tarjeta ya ha pasado.": "カードの有効期限が切れています。", "indica si el pedido es para regalo.": "ギフトかどうか選択してください。",
            "no se ha podido cargar el resumen del pedido.": "注文内容を読み込めませんでした。", "error al cargar el paso 2.": "ステップ2を読み込めませんでした。",
            "error al cargar la pregunta sobre el regalo.": "ギフトの質問を読み込めませんでした。", "error al cargar el resumen.": "確認画面を読み込めませんでした。",
            "error al registrar el usuario": "アカウントを登録できませんでした。", "no se ha podido cargar la pantalla de compra.": "購入手続きを読み込めませんでした。",
            "no se ha podido guardar los datos de envío.": "配送先情報を保存できませんでした。", "no se han podido guardar los datos de pago.": "支払い情報を保存できませんでした。",
            "no se ha podido confirmar el pedido.": "注文を確定できませんでした。", "no se ha podido cargar el carrito.": "カートを読み込めませんでした。",
            "no se ha podido eliminar el perfume.": "香水を削除できませんでした。", "no se ha podido actualizar la cantidad.": "数量を更新できませんでした。",
            "no se ha podido vaciar el carrito.": "カートを空にできませんでした。",
            "bienvenido a la administración de la tienda": "ショップ管理へようこそ",
            "gestionar perfumes": "香水を管理", "gestionar pedidos": "注文を管理", "gestionar categorías": "カテゴリーを管理",
            "tzaa jaa! · perfumería de autor": "TZAA JAA! · ニッチフレグランス", "la colección, cuidada hasta el último detalle.": "細部まで丁寧に選び抜かれたコレクション。",
            "buscar en la colección": "コレクションを検索", "nombre o marca": "名前またはブランド", "perfume en la colección": "点の香水",
            "perfumes en la colección": "点の香水", "+ añadir perfume": "+ 香水を追加", "editar ficha": "詳細を編集",
            "no hay perfumes que coincidan": "一致する香水がありません", "prueba con otro nombre o marca para encontrar una fragancia.": "別の名前やブランドで検索してください。",
            "gestionar usuarios": "ユーザーを管理", "registrar perfume": "香水を登録", "volver a la tienda": "ショップに戻る",
            "editor de colección": "コレクション編集", "ajusta la ficha y conserva la esencia de cada fragancia.": "香りの個性を保ちながら商品情報を編集します。",
            "volver a perfumes": "香水一覧に戻る", "vista de catálogo": "カタログ表示", "la imagen actual se conserva si no seleccionas una fotografía nueva.": "新しい写真を選ばない場合、現在の画像を保持します。",
            "información de la fragancia": "香水の詳細", "datos que se muestran en la tienda.": "ショップに表示される情報です。", "género o estilo": "性別・スタイル", "familia olfativa": "香りの系統",
            "fotografía del frasco": "ボトルの写真", "imagen principal que aparece en el catálogo.": "カタログに表示されるメイン画像です。", "fondo de la ficha": "商品ページの背景", "fondo editorial opcional al abrir la fragancia.": "香水の詳細を開いたときの背景画像（任意）。",
            "administración · perfumería": "管理 · 香水", "gestión de categorías": "カテゴリー管理",
            "organiza las categorías de perfumes de tu tienda.": "ショップの香水カテゴリーを整理します。", "+ nueva categoría": "+ 新しいカテゴリー",
            "nombre": "名前", "descripción": "説明", "acciones": "操作", "editar": "編集", "eliminar": "削除",
            "todavía no hay categorías registradas.": "カテゴリーはまだ登録されていません。", "crear categoría": "カテゴリーを作成",
            "editar categoría": "カテゴリーを編集", "nombre:": "名前：", "descripción:": "説明：", "guardar categoría": "カテゴリーを保存",
            "volver a categorías": "カテゴリーに戻る", "editar perfume": "香水を編集", "género": "性別", "precio": "価格", "mililitros": "容量",
            "categoría": "カテゴリー", "foto nueva": "新しい写真", "imagen de fondo de la ficha (opcional)": "商品ページの背景画像（任意）",
            "si no seleccionas otra, se conserva el fondo actual.": "新しい画像を選ばない場合、現在の背景を保持します。", "guardar cambios": "変更を保存",
            "volver": "戻る", "pedidos": "注文", "consulta las compras y revisa sus productos y datos de entrega.": "注文、商品、配送先情報を確認します。",
            "← volver al panel": "← 管理画面に戻る", "pedido": "注文", "fecha pendiente": "日付未定", "ver detalles": "詳細を見る",
            "aún no hay pedidos": "注文はまだありません", "cuando se confirme una compra, aparecerá aquí.": "購入が確定すると、ここに表示されます。",
            "vista actualizada · 29/10/2026 · 13:05 (hora peninsular)": "画面更新 · 2026/10/29 · 13:05（スペイン時間）",
            "perfume": "香水", "borrar": "削除", "¿estas seguro?": "よろしいですか？", "esta sección todavía no está implementada.": "このセクションはまだ実装されていません。",
            "login administrador": "管理者ログイン", "contraseña:": "パスワード：", "entrar": "ログイン",
            "detalle del pedido | tzaa jaa!": "注文詳細 | TZAA JAA!", "tzaa jaa! · detalle de compra": "TZAA JAA! · 注文詳細",
            "volver a pedidos": "← 注文に戻る", "estado del pedido": "注文状況", "01 · entrega": "01 · 配送", "datos del cliente": "お客様情報",
            "dirección": "住所", "provincia": "地域", "código postal": "郵便番号", "02 · pago": "02 · お支払い", "datos de pago": "お支払い情報",
            "titular": "名義人", "tarjeta": "カード", "terminada en": "下4桁", "no disponible": "利用不可",
            "por seguridad, aquí solo se muestran los últimos cuatro dígitos.": "安全のため、ここにはカード番号の下4桁のみ表示されます。",
            "03 · artículos": "03 · 商品", "perfumes del pedido": "注文商品", "artículos": "点", "cantidad:": "数量：",
            "este pedido todavía no tiene productos confirmados.": "この注文には確定した商品がまだありません。", "total del pedido": "注文合計",
            "← volver a todos los pedidos": "← 注文一覧に戻る", "perfume registrado": "香水を登録しました", "perfume registrado correctamente": "香水を登録しました",
            "ver perfumes": "香水を見る", "registrar otro": "別の香水を登録", "añade una nueva fragancia a la colección de tu tienda.": "ショップのコレクションに香水を追加します。",
            "información del perfume": "香水の情報", "introduce los datos de la fragancia.": "香水の情報を入力してください。", "nombre del perfume": "香水名",
            "ej. sauvage": "例：Sauvage", "ej. dior": "例：Dior", "introduce el género": "性別を入力してください", "contenido (ml)": "容量（ml）",
            "ej. 79.99": "例：79.99", "ej. 100": "例：100", "describe las características de la fragancia...": "香りの特徴を入力してください…",
            "fotografía del perfume": "香水の写真", "selecciona una imagen desde tu dispositivo.": "端末から画像を選択してください。",
            "imagen de fondo para la ficha (opcional)": "商品ページの背景画像（任意）", "se mostrará a pantalla completa al abrir este perfume.": "この香水を開くと画面いっぱいに表示されます。",
            "cancelar": "キャンセル", "guardar perfume →": "香水を保存 →", "perfumería · colección exclusiva": "香水 · 限定コレクション",
            "formulario de usuario": "ユーザーフォーム", "← volver a usuarios": "← ユーザー一覧に戻る", "gestiona los datos de la cuenta del usuario.": "ユーザーアカウント情報を管理します。",
            "correo electrónico": "メールアドレス", "apellidos": "姓", "teléfono": "電話番号", "gestión de usuarios | perfumería": "ユーザー管理 | 香水",
            "gestión de usuarios": "ユーザー管理", "consulta y administra los usuarios de tu tienda.": "ショップのユーザーを確認・管理します。", "+ nuevo usuario": "+ 新しいユーザー",
            "email": "メール", "todavía no hay usuarios registrados.": "ユーザーはまだ登録されていません。", "crear usuario": "ユーザーを作成", "editar usuario": "ユーザーを編集",
            "gestión de categorías | perfumería": "カテゴリー管理 | 香水", "formulario de categoría": "カテゴリーのフォーム",
            "pendiente": "保留中", "en preparación": "準備中", "enviado": "発送済み", "entregado": "配達済み",
            "¿seguro que quieres eliminar esta categoría?": "このカテゴリーを削除してもよろしいですか？", "¿seguro que quieres eliminar este usuario?": "このユーザーを削除してもよろしいですか？",
            "return confirm('¿estas seguro?')": "return confirm('よろしいですか？')",
            "return confirm('¿seguro que quieres eliminar esta categoría?')": "return confirm('このカテゴリーを削除してもよろしいですか？')",
            "return confirm('¿seguro que quieres eliminar este usuario?')": "return confirm('このユーザーを削除してもよろしいですか？')"
        }
    };

    const idiomaPermitido = new Set(["es", "en", "ja"]);
    const url = new URL(window.location.href);
    const idiomaQuery = url.searchParams.get("idioma");
    const idiomaGuardado = localStorage.getItem("idioma");
    const idiomaDePagina = document.body.classList.contains("scent-finder-page")
        ? (idiomaGuardado || document.documentElement.lang)
        : (document.documentElement.lang || idiomaGuardado);
    let idioma = idiomaPermitido.has(idiomaQuery) ? idiomaQuery : (idiomaDePagina || "es");
    if (!idiomaPermitido.has(idioma)) idioma = "es";
    localStorage.setItem("idioma", idioma);
    document.documentElement.lang = idioma;
    document.querySelectorAll("[data-idioma]").forEach(boton => {
        boton.setAttribute("aria-pressed", String(boton.dataset.idioma === idioma));
    });
    if (document.body.classList.contains("scent-finder-page")) {
        document.title = idioma === "en" ? "Scent Finder | TZAA JAA!" : (idioma === "ja" ? "香りを見つける | TZAA JAA!" : "Scent Finder | TZAA JAA!");
    }

    const originalTexto = new WeakMap();
    const originalAtributo = new WeakMap();
    const normalizar = texto => texto.replace(/\s+/g, " ").trim().toLocaleLowerCase("es");
    const conservarEspacios = (actual, nuevo) => {
        const inicio = actual.match(/^\s*/)?.[0] || "";
        const fin = actual.match(/\s*$/)?.[0] || "";
        return `${inicio}${nuevo}${fin}`;
    };

    function traducirTexto(node) {
        if (!originalTexto.has(node)) originalTexto.set(node, node.nodeValue);
        const fuente = originalTexto.get(node);
        const clave = normalizar(fuente);
        const diccionario = traducciones[idioma];
        if (idioma === "es") {
            node.nodeValue = fuente;
            return;
        }
        let resultado = diccionario[clave];
        if (idioma === "en" && clave.startsWith("bienvenido ")) resultado = `Welcome ${fuente.trim().slice("Bienvenido".length).trim()}`;
        if (idioma === "ja" && clave.startsWith("bienvenido ")) resultado = `ようこそ ${fuente.trim().slice("Bienvenido".length).trim()}`;
        const progreso = clave.match(/^pregunta (\d+) de (\d+)$/);
        if (progreso) resultado = idioma === "en" ? `QUESTION ${progreso[1]} OF ${progreso[2]}` : `質問 ${progreso[1]} / ${progreso[2]}`;
        const articulos = clave.match(/^(\d+) artículos?$/);
        if (articulos) resultado = idioma === "en" ? `${articulos[1]} item${articulos[1] === "1" ? "" : "s"}` : `${articulos[1]} 点`;
        const cantidadPedido = clave.match(/^cantidad:\s*(\d+)$/);
        if (cantidadPedido) resultado = idioma === "en" ? `Quantity: ${cantidadPedido[1]}` : `数量：${cantidadPedido[1]}`;
        const porcentaje = clave.match(/^(\d+) %$/);
        if (porcentaje) resultado = `${porcentaje[1]}%`;
        if (resultado) node.nodeValue = conservarEspacios(fuente, resultado);
    }

    function traducirAtributos(elemento) {
        ["placeholder", "aria-label", "title", "alt", "onclick"].forEach(nombre => {
            if (!elemento.hasAttribute(nombre)) return;
            let atributos = originalAtributo.get(elemento);
            if (!atributos) { atributos = {}; originalAtributo.set(elemento, atributos); }
            if (!(nombre in atributos)) atributos[nombre] = elemento.getAttribute(nombre);
            const original = atributos[nombre];
            const traducido = traducciones[idioma]?.[normalizar(original)];
            const valorFinal = traducido || original;
            if (elemento.getAttribute(nombre) !== valorFinal) elemento.setAttribute(nombre, valorFinal);
        });
        if (elemento.matches('input[type="submit"], input[type="button"]')) {
            let atributos = originalAtributo.get(elemento);
            if (!atributos) { atributos = {}; originalAtributo.set(elemento, atributos); }
            if (!("value" in atributos)) atributos.value = elemento.value;
            elemento.value = traducciones[idioma]?.[normalizar(atributos.value)] || atributos.value;
        }
    }

    function traducirArbol(raiz) {
        if (raiz.nodeType === Node.TEXT_NODE) { traducirTexto(raiz); return; }
        if (raiz.nodeType !== Node.ELEMENT_NODE && raiz !== document) return;
        if (raiz.nodeType === Node.ELEMENT_NODE) traducirAtributos(raiz);
        const walker = document.createTreeWalker(raiz, NodeFilter.SHOW_TEXT);
        let node;
        while ((node = walker.nextNode())) traducirTexto(node);
        if (raiz.querySelectorAll) raiz.querySelectorAll("[placeholder], [aria-label], [title], [alt], [onclick], input[type='submit'], input[type='button']").forEach(traducirAtributos);
    }

    function propagarIdiomaEnlaces() {
        document.querySelectorAll('a[href]').forEach(enlace => {
            if (enlace.hash || enlace.hasAttribute("data-no-idioma")) return;
            const destino = new URL(enlace.href, window.location.href);
            if (destino.origin !== window.location.origin) return;
            destino.searchParams.set("idioma", idioma);
            enlace.href = destino.href;
        });
    }

    function cambiarIdioma(codigo) {
        if (!idiomaPermitido.has(codigo)) return;
        idioma = codigo;
        localStorage.setItem("idioma", codigo);
        const destino = new URL(window.location.href);
        destino.searchParams.set("idioma", codigo);
        window.location.assign(destino.href);
    }

    document.addEventListener("click", evento => {
        const boton = evento.target.closest("[data-idioma]");
        if (boton) cambiarIdioma(boton.dataset.idioma);
    });

    const alertaOriginal = window.alert.bind(window);
    window.alert = mensaje => {
        const traducido = traducciones[idioma]?.[normalizar(String(mensaje))];
        alertaOriginal(traducido || mensaje);
    };

    traducirArbol(document);
    propagarIdiomaEnlaces();
    new MutationObserver(cambios => {
        cambios.forEach(cambio => {
            cambio.addedNodes.forEach(nodo => traducirArbol(nodo));
            if (cambio.type === "attributes") traducirAtributos(cambio.target);
        });
        propagarIdiomaEnlaces();
        }).observe(document.body, {childList: true, subtree: true, attributes: true, attributeFilter: ["placeholder", "aria-label", "title", "alt", "onclick"]});
})();
