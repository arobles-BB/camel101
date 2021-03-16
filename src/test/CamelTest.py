import sys
import time

class CamelTest:

	def __init__(self):
		self._txt = ''

	def new_file(self, init_text):
		self._txt = init_text

	def create(self, somepath):
		f = open(somepath+"/demo.txt", "a")
		f.write(self._txt)
		f.close()
	def check(self, somepath):
		f = open(somepath+"/demo.txt", "r")
		testTxt = f.read()
		print("file with text: "+ testTxt)
		f.close()
		if self._txt.lower() != testTxt:
			raise AssertionError("something went wrong!\r\n <"+self._txt.lower()+"> <> <"+testTxt+">")
	def queue_wait(self,amount):
		try:
			num = float(amount)
			time.sleep(num)
		except ValueError:
			print("Please enter in a number.\n")


#object = CamelTest()
#object.new_file("init text!")
#object.create("/tmp")
#object.queue_wait(5)
#object.check("/tmp")

