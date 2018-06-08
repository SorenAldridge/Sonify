'''
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
 '''

 #Author: Soren Zhane Chapman-Aldridge
 #Date Created: 6/6/18

from tkinter import filedialog
from tkinter import Tk
import csv
import numpy
import math
import os, sys
from numpy import vstack

MIDI_SIZE = 4
subarray = []
midinotes = numpy.empty((1000,4))
i = 0

print(midinotes)
print(subarray.__sizeof__)
#set Tk() as root 
root = Tk()
#hide tk root window
root.withdraw()
#open filechooser to select csv file
root.filename =  filedialog.askopenfilename(initialdir = os.path.dirname(sys.argv[0])+'\Test Files' ,title = "Select file",filetypes = (("csv files","*.csv"),("txt files","*.txt"),("all files","*.*")))

#open csv reader
with open(root.filename, newline='') as csvfile:
    csvreader = csv.reader(csvfile, delimiter=',', quotechar='|')
    for row in csvreader:
        print(row)
        midinotes = vstack((midinotes, row))
        
    print(midinotes)