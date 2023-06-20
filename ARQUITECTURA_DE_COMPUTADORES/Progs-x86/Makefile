all:hola add

hola:	hola.asm 
	nasm -felf64 hola.asm
	ld -o hola hola.o

add:	add.asm
	nasm -felf64 add.asm
	ld -o add add.o

clean:
	rm *.o 