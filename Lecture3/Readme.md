### Задание третей лекции. Аналог букинга
**На выполнение дается 1 неделя**
Начинаем реализацию своего букинга.
Для начала нужно написать программу, которая выводит по каждому из отелей:
- общее количество номеров
- список номеров с их описанием

Номера бывают:
- Однокомнатные
- Двухкомнатные
- Трехкомнатные

Каждый из номеров может иметь следующие дополнения/услуги, список может расширяться в последующем:
- балкон
- уборка номера
- интернет
- кондиционер
- шашлычок в номер

#### На входе
Отель "У мамы лучше":\
Время заселения: 12:00
- 5 номеров
  - 1 однокомнатный номер с балконом (цена 1000 р/сутки, вместимость до 2 человек, время заселения 12:00)
  - 2 двухкомнатных номера с балконом, уборкой номера, интернетом и кондиционером (цена 3000 р/сутки, вместимость до 4 человек, время заселения 12:00)
  - 1 трехкомнатный номер (цена 2500 р/сутки, вместимость до 6 человек, время заселения 12:00)
  - 1 трехкомнатный номер с балконом и интернетом (цена 3500 р/сутки, вместимость до 6 человек, время заселения 12:00)

Отель "Шашлычок":\
Время заселения: 09:00
- 3 номера
    - 1 однокомнатный номер с шашлычком в номер (цена 1000 р/сутки, вместимость до 2 человек, время заселения 09:00)
    - 1 двухкомнатный номер с балконом и уборкой номера (цена 2000 р/сутки, вместимость до 4 человек, время заселения 09:00)
    - 1 трехкомнатный номер с уборкой номера (цена 4000 р/сутки, вместимость до 6 человек, время заселения 09:00)

#### Пример вывода:
Отель "У мамы лучше":\
Количество номеров: 4\
Номера:
- Однокомнатный номер (комната номер 13):
  - Цена: 100 р/сутки
  - Время заселение/выселения: 12:00
  - Дополнительные услуги: балкон, уборка номера, кондиционер
- Однокомнатный номер (комната номер 14):
    - Цена: 100 р/сутки
    - Время заселение/выселения: 24:00
    - Дополнительные услуги: балкон\

....