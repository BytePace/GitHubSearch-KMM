# Пример приложения с архитектурой MVVM
Здесь представлен пример исполнения тестового задания для стажеров в BytePace.
Используемые технологии:
* [Android lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle) (Управление состоянием приложения, подписки и т.п.).
* [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) (Многопоточность в приложении).
* [Android paging](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) (постраничная загрузка в адаптер RecyclerView).
* [Dagger2](https://developer.android.com/training/dependency-injection/dagger-android) (библиотека для управления зависимостями ([Dependency Injection](https://ru.wikipedia.org/wiki/%D0%92%D0%BD%D0%B5%D0%B4%D1%80%D0%B5%D0%BD%D0%B8%D0%B5_%D0%B7%D0%B0%D0%B2%D0%B8%D1%81%D0%B8%D0%BC%D0%BE%D1%81%D1%82%D0%B8))).
* [terrakok/Cicerone](https://github.com/terrakok/Cicerone) (навигация по экранам в приложении).
* [Retrofit](https://square.github.io/retrofit/) + [OkHttp](https://square.github.io/okhttp/) + [Gson](https://github.com/google/gson) (сетевой слой: отправка запросов, парсинг ответов).
* [DataBinding](https://developer.android.com/topic/libraries/data-binding) (библиотека для упрощения связывания UI-логики с xml-разметкой).

Данный пример далеко не идеален, поэтому со временем будет дополняться. Если у вас есть предложения по улучшению или нашли ошибку - используйте issues и pull requests.

## Советы по используемым технологиям:
* **terrakok/Cicerone** лучше заменить на [terrakok/Modo](https://github.com/terrakok/Modo). Принцип тот же, но в Modo лучше реализована мультистековая навигация.
* необходимо добавить в проект [LeakCanary](https://square.github.io/leakcanary/), чтобы вовремя устранять утечки памяти в приложении.
* при разработке и тестировании приложения необходимо включать флаг ["Don't keep activities"](https://habr.com/ru/post/221679/) ("Вытеснение фоновых активити). Данная настройка поможет лучше обработать savingState на стадии разработки (до передачи в тестирование).
* для работы с БД используем [Room](https://developer.android.com/training/data-storage/room).

## Советы по разработке:
* желательно не игнорировать unit-тестирование (стоит обсуждать с руководством и непосредственно с заказчиком, т.к. на написание тестов тоже уходит время).
* крайне желательно не игнорировать [SOLID](https://medium.com/webbdev/solid-4ffc018077da) и [принципы ООП](https://habr.com/ru/post/87205/).
* не стоит пренебрегать хорошей декомпозицией и нормальным неймингом пакетов, файлов и переменных.
* крайне желательно не использовать Deprecated-инструменты.
* крайне желательно придерживаться [кодстайла](https://developer.android.com/kotlin/style-guide).
* если возникают сложные ситуации или вопросы - смело обращайся к другим разработчикам, выноси проблему на обсуждение.

## Полезная литература:
* "Паттерны проектирования" Банды 4х: [оригинал](https://docs.google.com/file/d/0B6GuCegBf3X3Tm1rZl9BUTduQm8/edit?resourcekey=0-ME3Ni9D9Wae8zLuAbNPx6w) и [сокращение](https://bool.dev/blog/detail/gof-design-patterns)
* 
### Успехов!
