#!/usr/bin/python3

import threading

counter = 0
flag1 = [False, "flag1"]
flag2 = [False, "flag2"]
turn = 1

def block_it(my_flag, its_flag, its_turn):
    my_flag[0] = True
    turn = its_turn

    while (its_flag[0] and turn == its_turn):
        pass


def unblock_it(my_flag):
    if my_flag[1] == 'flag1':
        global flag1
        flag1[0] = False
    else:
        global flag2
        flag2[0] = False


class myThread (threading.Thread):


    def __init__(self, my_flag, its_flag, its_turn):
        threading.Thread.__init__(self)
        self.my_flag = my_flag
        self.its_flag = its_flag
        self.its_turn = its_turn


    def run(self):
        global counter

        block_it(self.my_flag, self.its_flag, self.its_turn)

        for _ in range(0,100_000):
            counter += 1

        unblock_it(self.my_flag)


# Create new threads
thread1 = myThread(flag1, flag2, 1)
thread2 = myThread(flag2, flag1, 2)

# Start new Threads
thread1.start()
thread2.start()

thread1.join()
thread2.join()

print(f'Value of counter variable: {counter}')

print ("Exiting Main Thread")