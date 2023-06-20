section .data
	hello:     db 'Hola Mundo!',0xA,0xD    ; 'Hola Mundo!' mas los bytes NL y CR
	helloLen:  equ $-hello                 ; longitud de 'Hello world!' y los bytes NL y CR 
	len:	   db 0x07                     ; x07 - BELL. Cuando salga a la consola, sonara la campana 1 vez.
	ll:        equ 1

section .text
	global _start

_start:
	mov eax,4            ; system call del kernel write (sys_write)
	mov ebx,1            ; descriptor de archivo 1 - standard output
	mov ecx,hello        ; direccion de memoria donde esta almacenada la cadena "Hola Mundo!" 
	mov edx,helloLen     ; longitud de la cadena y los bytes NL y CR
	int 80h              ; llamada al kernel 

	mov eax,4            ; system call write (sys_write)
	mov ebx,1            ; descriptor de archivo  1 - standard output
	mov ecx,len          ; direccion en memoria de la variable len (almacena el numero 23)
	mov edx,ll           ; numero de bytes (1) que "sale" a la consola, a pardir de la direccion len
	int 80h              ; llamada al kernel (OJO: el numero 23 saldra e la consola en BINARIO)

	mov eax,1            ; system call exit (sys_exit)
	mov ebx,0            ; argumento (codigo) de exit (0 - no e6rror)
	int 80h
