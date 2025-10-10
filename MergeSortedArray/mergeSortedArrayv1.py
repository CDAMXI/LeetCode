def merge(nums1, m, nums2, n):
    p1 = m - 1  # Último elemento válido en nums1
    p2 = n - 1  # Último elemento en nums2
    p = m + n - 1  # Última posición total de nums1

    # Mezclar desde el final hacia el inicio
    while p1 >= 0 and p2 >= 0:
        if nums1[p1] > nums2[p2]:
            nums1[p] = nums1[p1]
            p1 -= 1
        else:
            nums1[p] = nums2[p2]
            p2 -= 1
        p -= 1

    # Si aún quedan elementos en nums2, copiarlos
    while p2 >= 0:
        nums1[p] = nums2[p2]
        p2 -= 1
        p -= 1


# Ejemplo de uso (main)
if __name__ == "__main__":
    nums1 = [1, 2, 3, 0, 0, 0]
    m = 3
    nums2 = [2, 5, 6]
    n = 3

    merge(nums1, m, nums2, n)
    print("Resultado:", nums1)
