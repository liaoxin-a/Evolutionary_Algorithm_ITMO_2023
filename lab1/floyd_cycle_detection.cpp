#include <iostream>
#include <unordered_set>
#include<time.h>
using namespace std;
 
// Узел связанного списка
struct Node
{
    int data;
    Node* next;
};
 
// Вспомогательная функция для создания нового узла с заданными данными и
// помещает его в начало списка
void push(Node*& headRef, int data)
{
    // создаем новый узел связанного списка из кучи
    Node* newNode = new Node;
 
    newNode->data = data;
    newNode->next = headRef;
    headRef = newNode;
}
 
// Функция для обнаружения цикла в связанном списке с использованием
// Алгоритм обнаружения циклов Флойда
bool detectCycle(Node* head)
{

    // взять два указателя — `slow` и `fast`
    Node *slow = head, *fast = head;
 
    while (fast && fast->next)
    {
        // медленно двигаться на один указатель
        slow = slow->next;
 
        // быстро перемещаемся на два указателя
        fast = fast->next->next;

        // cout << "slow.data=" << slow->data << endl;
        // cout << "fast.data=" << fast->data << endl;
        // если они встречаются с каким-либо узлом, связанный список содержит цикл
        if (slow == fast) {
            cout << "return True" << endl;
            cout << "fast.data=" << fast->data << endl;
            return true;
        }
    }
 
    // мы доходим сюда, если медленный и быстрый указатель не встречаются
    return false;
}
 
int main()
{
    // ключи ввода
    const int node_num=1000000;

    // int keys[] = { 1, 2, 3, 4, 5 };
    // int n = sizeof(keys) / sizeof(keys[0]);
 
    Node* head = nullptr;
    Node *last_node = nullptr;
    for (int i = node_num - 1; i >= 0; i--) {
        push(head, i+1);
        if (i == node_num-1){
            last_node = head;
        }
    }
 
    // вставить цикл
    //last_node.next=third node
    // head->next->next->next->next->next = head->next->next;
    last_node->next=head->next->next;
    clock_t start_time, end_time;
    start_time = clock();
    if (detectCycle(head)) {
        cout << "Cycle Found";
    }
    else {
        cout << "No Cycle Found";
    }
    end_time = clock();
    cout << endl <<"time=" << (double)(end_time - start_time)/CLOCKS_PER_SEC<<"s"<<endl;
    return 0;
}