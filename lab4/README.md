# Laboratory №4
**Дата:** 13/03/2023

**Выполнил:** Liao Xin, M4150 

**Название:** Генетический алгоритм для решения задачи коммивояжёра


**Описание структуры каталогов:**
```
./
│   readme.md
│      
├───src
│   └───main
│       ├───java
│       │   └───lab3
│       └───resourse
└───target
    ├───classes
    │   └───lab3
    └───test-classes
```
## Описание: 
Скачать следующие файлы из https://gitlab.com/itmo_ec_labs/lab3 для реализации оператора инициализации решений,оператора кроссовера,фитнес-функции,оператора мутации и представления решений.
- TspAlg.java – основной класс проекта;
- TspCrossover.java – реализация оператора кроссовера;
- TspFactory.java – реализация оператора инициализации решений;
- TspFitnessFunction.java – реализация фитнес-функции;
- TspMutation.java – реализация оператора мутации;
- TspSolution.java – реализация представления решений.

## Описание выполнения:
- Скачать репозиторий с исходным кодом заглушек проекта: https://gitlab.com/itmo_ec_labs/lab3
- реализация оператора инициализации решений
- реализация оператора кроссовера
- реализация фитнес-функции
- реализация оператора мутации
- реализация представления решений
- Эксперименты с "XQF131","XQG237","PMA343","PKA379","BCL380"
- Ответы на поставленные вопросы

## Реализация оператора инициализации решений
 Используется метод ближайшего соседа.
 В методе ближайшего соседа принцип жадности реализуется следующим образом:на каждом шаге следующий город выбирается из всех невключенных в обход так, чтобы он был ближайшим к последнему посещенному.
        //start city
        int city0 = 0;
        while (city0 == 0 || start_citys.contains(city0)) {
            city0 = 1 + random.nextInt(city_size);
        }
        start_citys.add(city0);
        route_list.add(city0);
        
        for (int i = 0; i < city_size-1; i++) {
            int nearest_neighbor = 0;
            double dis;
            nearest_neighbor = find_nearest_neighbor(route_list.get(i), route_list);

            route_list.add(nearest_neighbor);}
## Реализация оператора кроссовера
 Используется упорядоченный кроссовер.
 Первый шаг алгоритма – выбор двух точек 𝑎 и 𝑏 . Потомок целиком наследует середину от первого родителя 𝑃1. Второй шаг алгоритма – обход всех незадействованных генов в порядке второго родителя 𝑃2, начиная от позиции 𝑏.
```
int crossoverfromIndex = random.nextInt(rout_len);
int crossovertoIndex = crossoverfromIndex;
while (crossoverfromIndex == crossovertoIndex) {
    crossovertoIndex = random.nextInt(rout_len);
}
if (crossoverfromIndex > crossovertoIndex) {
    int tmp = crossoverfromIndex;
    crossoverfromIndex = crossovertoIndex;
    crossovertoIndex = tmp;
}
List<Integer> sub_p1 = p1.getroure().subList(crossoverfromIndex, crossovertoIndex);
List<Integer> sub_p2 = p2.getroure().subList(crossoverfromIndex, crossovertoIndex);
```
## Фитнес-функции  
Сначала реализация чтение файла. Затем матрицу расстояний создан,рассчитать евклидово расстояние между двумя городами через координаты городов.
```
double totalDistance = 0;
int cityCount = solution.getsize();
for (int i = 0; i < cityCount; i++) {
    int nextIndex = i < cityCount - 1 ? i + 1 : 0;
    totalDistance += get_distance(solution.get(i),solution.get(nextIndex));
}
```

## Реализация оператора мутации
Фрагменты генов выбираются случайным образом для shuffle
```
    List<Integer> new_rout=new ArrayList<Integer>(population.get(i).getroure());
    int mutfromIndex = random.nextInt(rout_len);
    int muttoIndex = mutfromIndex;
    List<Integer> sub_p1 = new_rout.subList(mutfromIndex, muttoIndex);
    Collections.shuffle(sub_p1);
    TspSolution mut_indv = new TspSolution(new_rout);.
```
## Эксперименты: 
| Проблема | Размер | Параметры popsize и gens | Длина маршрута | Количество итераций до сходимости |Оптимальный маршрут|
| ------- |------| ------| ------| ------|------|
| XQF131 | 131 |	10,10 | 694.891 | 0 | 564 |
| XQF131 | 131 | 100,10000 | 662.821 | 3209 |  564 |
| XQG237 | 237 |	10,10 | 1241.59 | 0 | 1019|
| XQG237 | 237 | 100,10000 | 1206.756 | 7372 | 1019|
| PMA343 | 343 |	10,10 | 1655.441 | 0 | 1368 |
| PMA343 | 343 | 100,10000 | 1621.804 | 6452 | 1368 |
| PKA379 | 379 |	10,10 | 1634.006 | 0 | 1332 |
| PKA379 | 379 | 100,10000 | 1592.456 | 3221 | 1332 |
| BCL380 | 380 |	10,10 | 1912.537 | 0 | 1621 |
| BCL380 | 380 | 100,10000 | 1855.152 | 1324 | 1621 |

## Вопросы 
1. Можно ли определить, что полученное решение является глобальным оптимумом?
    - нельзя,решение может быть локальный оптимум.

2. Можно ли допускать невалидные решения (с повторением городов). Если да, то как обрабатывать такие решение и как это повлияет на производительность алгоритма?
    - Можно.Установка fitness этого типа решение к числу, близкому к 0  при isNatural()=True, уменьшит вероятность его попадания в следующее поколение, будет очень низкой. Но в то же время этот результат делает популяцию более разнообразной.

3. Как изменится задача, если убрать условие необходимости возврата в исходную точку маршрута?
   - Результат может быть совершенно другим. Возможно, конечный город находится далеко от начальной города.
