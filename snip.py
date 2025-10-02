import os
import sys

given_files = os.listdir()
for extensions in given_files:
    index = 0
    if str(extensions).find(".bc") != -1:
        given_files[index] = str(extensions).replace(".bc", "")
    if str(extensions).find(".h1") != -1:
        given_files[index] = str(extensions).replace(".h1", "")

    print(f"\nNEXT WEBSITE(S) TEST:\n\t{given_files}")