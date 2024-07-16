# Digital Chief тестовое задание

### Бизнес модель продукта

Разработать backend-приложения для управления компанией и её сотрудниками.
В системе будут две основные сущности: Компания и Сотрудники. Каждая компания имеет несколько сотрудников
(отношение "один ко многим")

### Сущности продукта
* Компания:
  * Id (id) - уникальный идентификатор компании;
  * Название (name) - название компании;
  * Адрес (address) - адрес компании;
  * Год основания (yearOfEstablishment) - год основания компании;
  * Отрасль (industry) - отрасль, в которой работает компания.
* Сотрудники:
  * Id (id) - уникальный идентификатор сотрудника;
  * Имя (Name) - полное имя сотрудника;
  * Должность (Position) - должность сотрудника;
  * Зарплата (Salary) - зарплата сотрудника;
  * Компания (Company) - ссылка на идентификатор компании (внешний ключ).

### API Методы
1. Компания:
   * Создание компании (Create Company):
     * Метод: POST 
     * URL: /companies 
     * Входные данные: JSON-объект с полями name, address, year_of_establishment, industry. 
     * Выходные данные: JSON-объект с данными созданной компании. 
   * Получение списка компаний (Get Companies)
     * Метод: GET
     * URL: /companies
     * Входные данные: нет.
     * Выходные данные: JSON-массив с объектами компаний.
   * Получение компании по ID (Get Company by ID)
     * Метод: GET 
     * URL: /companies/{id} 
     * Входные данные: идентификатор компании в URL. 
     * Выходные данные: JSON-объект с данными компании. 
   * Обновление данных компании (Update Company)
     * Метод: PUT
     * URL: /companies/{id}
     * Входные данные: идентификатор компании в URL и JSON-объект с обновляемыми данными.
     * Выходные данные: JSON-объект с обновленными данными компании.
   * Удаление компании (Delete Company)
     * Метод: DELETE
     * URL: /companies/{id}
     * Входные данные: идентификатор компании в URL.
     * Выходные данные: статус операции.
2. Сотрудник
   * Создание сотрудника (Create Employee)
     * Метод: POST
     * URL: /employees
     * Входные данные: JSON-объект с полями name, position, salary, hire_date, company_id.
     * Выходные данные: JSON-объект с данными созданного сотрудника. 
   * Получение списка сотрудников (Get Employees)
     * Метод: GET
     * URL: /employees
     * Входные данные: нет.
     * Выходные данные: JSON-массив с объектами сотрудников.
   * Получение сотрудника по ID (Get Employee by ID)
     * Метод: GET
     * URL: /employees/{id}
     * Входные данные: идентификатор сотрудника в URL.
     * Выходные данные: JSON-объект с данными сотрудника.
   * Обновление данных сотрудника (Update Employee)
     * Метод: PUT
     * URL: /employees/{id}
     * Входные данные: идентификатор сотрудника в URL и JSON-объект с обновляемыми данными.
     * Выходные данные: JSON-объект с обновленными данными сотрудника.
   * Удаление сотрудника (Delete Employee)
     * Метод: DELETE
     * URL: /employees/{id}
     * Входные данные: идентификатор сотрудника в URL.
     * Выходные данные: статус операции.
