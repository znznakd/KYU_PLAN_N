from collections import deque

def deque_process(n):
    my_deque = deque([i for i in range(1, n + 1)])
    while(len(my_deque) != 1):
        my_deque.popleft()
        my_deque.rotate(-1)
    return my_deque[0]

def another_process(n):
    pow_val = 1
    while pow_val < n:
        pow_val *= 2
    return n*2 - pow_val # pow_val-2*(pow_val - n)

print("test start")
for i in range(1,1001):
    if (another_process(i) != deque_process(i)):
        print("wrong value!")
print("test end")
