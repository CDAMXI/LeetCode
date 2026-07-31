import keyboard

print("Presiona cualquier tecla (presiona 'esc' para salir)...")

while True:
    # Lee el evento de la tecla
    evento = keyboard.read_event()
    
    # Filtramos solo cuando la tecla se presiona (para evitar que se imprima también al soltarla)
    if evento.event_type == keyboard.KEY_DOWN:
        print(f"Has presionado: {evento.name}")
        
    # Condición de salida
    if evento.name == 'esc':
        print("Saliendo del programa...")
        break
