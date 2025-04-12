def validar_dni(dni):
    letras = "TRWAGMYFPDXBNJZSQVHLCKE"
    
    if len(dni) != 9 or not dni[:-1].isdigit() or not dni[-1].isalpha():
        return False

    numero = int(dni[:-1])
    letra_correcta = letras[numero % 23]
    
    return dni[-1].upper() == letra_correcta

# Ejemplo de uso
while True:
    dni_usuario = input("Introduce tu DNI (sin espacios, con letra): ").strip()

    if validar_dni(dni_usuario):
        print("✅ DNI válido.")
    else:
        print("❌ DNI no válido.")
