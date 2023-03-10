# Lab №2
**Student:** Liao Xin, M4150 

Скачать проект, содержащий фрэймворк Watchmaker и реализованные на нём примеры.

**Описание структуры каталогов:**
```
./
├───img
└───watchmaker_test
    ├───.vscode
    ├───bin
    │   ├───examples
    │   ├───monalisa
    │   ├───src
    │   └───travellingsalesman
    ├───lib
    └───src
        ├───bits
        ├───examples
        ├───monalisa
        └───travellingsalesman
```

## Описание 
The Watchmaker Framework for Evolutionary Computation is an extensible, high-performance, object-oriented framework for implementing platform-independent evolutionary algorithms in Java. It is freely available under a permissive Open Source licence. It can be downloaded from http://watchmaker.uncommons.org.

## Описание выполнения:
- Download the original files from https://github.com/dwdyer/watchmaker.
- Read the code to learn how to use each Class.
- Create a java project.Rebuilt the examples 'BitsExample','Monalisa','Travelling salesman'.
- Do 'BitsExample' experiment.
- Do 'Travelling salesman' experiment.
- Do 'Monalisa' experiment.
- Answer the questions from lab.

## Bits Count
The algorithm evolves bit strings and the fitness function simply counts the number of ones in the bit string.  The evolution should therefore converge on strings that consist only of ones.
| BITS length | Run 1 | Run 2 | Run 3 | Run 4 | Run 5 | Average |
| ------- |------| ------| ------| ------| ------| ------|
| 20 | 28 |	20 | 14	| 38 | 94 | 38.8 |
| 50 | 2,134 | 3,346 | 906 | 1,755 | 4,202 | 2,468.6 |
| 100 | 6,000,562 | 34,664,263 | 4,653,753 | 335,742 | 5,664,653 | 10,263,794.6|

## Traveling salesman
Travelling Salesman problem.The number of cities is from 1 to 15.In this experiment the city of number is 15.

| Population | Elitism | Number of generations | Selection strategy | Distance(km) | Elapsed time(s) |
| ------- |------| ------| ------| ------| ------|
| 300 | 3 | 100 | Truncation 50 | 10494.0 | 1.275 |
| 300 | 10 | 100 | Truncation 50 | 10494.0 | 0.089 |
| 300 | 50 | 100 | Truncation 50 | 10494.0 | 0.065 |

**Best solution:**  Brussels -> Luxembourg -> Paris -> London -> Dublin -> Lisbon -> Madrid -> Rome -> Athens -> Vienna -> Berlin -> Helsinki -> Stockholm -> Copenhagen -> Amsterdam -> Brussels 
						
## Monalisa
It attempts to find the combination of 50 translucent polygons that most closely resembles Leonardo da Vinci's Mona Lisa.
 
| Subjective result | Number of generations | Fitness | Number of polygons |  Number of angles Solution | image |
| ------- |------| ------| ------| ------| ------|
| bad | 1161 | 392593.505 | 10 | 61 | ![bad_img](https://github.com/liaoxin-a/Evolutionary_Algorithm_ITMO_2023/blob/main/lab2/img/bad.JPG) |
| generally | 13329 | 228753.321 | 28 | 215 | ![generally_img](https://github.com/liaoxin-a/Evolutionary_Algorithm_ITMO_2023/blob/main/lab2/img/normal.JPG) |
| good | 134570	| 187925.826 | 50 | 410 |  ![good_img](https://github.com/liaoxin-a/Evolutionary_Algorithm_ITMO_2023/blob/main/lab2/img/good.JPG) |


## Answers to questions

1. К какому типу по структуре решений относится каждая из рассмотренных задач?
    - Bits Counts — vector
    - Traveling Salesman — combinatorial
    - Mona Lisa — combinatorial

2. Как закодированы решения в задаче коммивояжёра?

  As a list of cities, which are to be visited by the travelling salesman in order.

3. Что является генотипом, а что фенотипом в задаче воспроизведения картины?
    - The genotype is  a set of polygons describing the picture.
    - Phenotype is polygon generated image.


