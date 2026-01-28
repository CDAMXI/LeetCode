def generate(num_rows):
    result = []  # Lista principal

    if num_rows <= 0:
        return result  # Si no hay filas, devolver lista vacía

    # Primera fila siempre [1]
    result.append([1])

    # Construir las filas desde la segunda hasta num_rows
    for i in range(1, num_rows):
        prev_row = result[i - 1]  # Fila anterior
        current_row = [1]  # Primer elemento siempre 1

        # Construir los elementos intermedios usando la fila anterior
        for j in range(1, len(prev_row)):
            current_row.append(prev_row[j - 1] + prev_row[j])

        current_row.append(1)  # Último elemento siempre 1

        result.append(current_row)  # Agregar la nueva fila al resultado

    return result


def main():
    is_valid = False
    while not is_valid:
        try:
            rows = int(input("Enter the number of rows desired for Pascal's Triangle: "))
            if rows <= 0:
                print("Please enter a positive integer.")
                continue  # Pedir de nuevo un valor válido

            pascal_triangle = generate(rows)
            for row in pascal_triangle:
                print(row)

            is_valid = True  # Valor válido → salir del bucle
        except ValueError:
            print("Invalid input. Please enter a positive integer.")


if __name__ == "__main__":
    main()
