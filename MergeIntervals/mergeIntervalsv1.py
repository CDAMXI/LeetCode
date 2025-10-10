from typing import List

def merge(intervals: List[List[int]]) -> List[List[int]]:
    if len(intervals) <= 1:
        return intervals

    # Ordenar por el inicio de cada intervalo
    intervals.sort(key=lambda x: x[0])
    merged = [intervals[0]]

    for i in range(1, len(intervals)):
        # Si el final del último intervalo en merged se solapa con el inicio del actual
        if merged[-1][1] >= intervals[i][0]:
            # Fusionar los intervalos
            merged[-1][1] = max(merged[-1][1], intervals[i][1])
        else:
            # Añadir el nuevo intervalo
            merged.append(intervals[i])

    return merged


# Ejemplo de uso
if __name__ == "__main__":
    intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]
    result = merge(intervals)
    for interval in result:
        print(interval)
