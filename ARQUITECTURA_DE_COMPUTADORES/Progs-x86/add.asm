section .text
global _start              
_start:                     ; inicio del codigo del programa 
    mov     eax, 50
    mov     ebx, 5
    add     eax, ebx
    mov     [sum], eax

    mov     eax, 4          ; numreo de la system call (4 - sys_write)
    mov     ebx, 1          ; file descriptor (1 = stdout)
    mov     ecx, msg 	    ; direccion en memoria donde esta almacenada la cadena 
    mov     edx, len	    ; longitud de la cadena
    int     0x80            ; llamada al  kernel

    mov     eax, 4          ; numero de la llamada (4 - sys_write)
    mov     ebx, 1          ; file descriptor (1 - stdout)
    mov     ecx, sum
    mov     edx, 1
    int     0x80            ; llamada al kernel

    mov     eax, 1          ; system call exit (1 = sys_exit)
    int     0x80            ; llamada al kernel

section .data
    msg     db              "The sum is:", 0xA,0xD 
    len equ $ - msg    	    ; longitud de la cadena "The sum is:" y de los bytes NL y CR
    segment .bss	    ; seccion de variables no inicializadas
    sum resb 1		    ; reservar un byte para la variable sum (4 + 3 = 7; x07 - codigo ASCII de BEL)
