# Function to process assembly code and generate intermediate files
def process_assembly_code():
    try:
        # Open input and output files
        with open("Tesy/input.txt", "r") as input_file, \
             open("Tesy/symtab_m.txt", "w") as symtab_file, \
             open("Tesy/inter_m2.txt", "w") as inter_file, \
             open("Tesy/littab_m.txt", "w") as littab_file:

            # Initialize counters and data structures
            lc = 0  # Location counter
            sym_counter = lit_counter = 0  # Symbol and literal counters
            symtab = []  # Symbol table

            # Process each line of assembly code
            for line in input_file:
                lc += 1
                tokens = line.strip().split(maxsplit=2)

                # Handle START directive
                if len(tokens) == 2 and tokens[0] == "START":
                    lc = int(tokens[1])  # Set location counter to start address
                    inter_file.write(f"{lc}\t\t(AD 01) (C {lc})\n")
                    continue

                # Process instructions with 3 tokens
                if len(tokens) == 3:
                    # Map instruction mnemonics to their codes
                    ins = {
                        "STOP": "(IS 00)", "ADD": "(IS 01)", "SUB": "(IS 02)",
                        "MUL": "(IS 03)", "MOVER": "(IS 04)", "MOVEM": "(IS 05)", 
                        "COMP": "(IS 06)", "BC": "(IS 07)", "DIV": "(IS 08)",
                        "READ": "(IS 09)", "PRINT": "(IS 10)"
                    }.get(tokens[0], "")

                    # Map register names to their codes
                    reg = {
                        "AREG": "(01)", "BREG": "(02)", 
                        "CREG": "(03)", "DREG": "(04)"
                    }.get(tokens[1], "")

                    # Handle DC (Define Constant) directive
                    if "DC" in tokens[1]:
                        inter_file.write(f"(DL 01) (C {tokens[2]})")
                    # Handle DS (Define Storage) directive
                    elif "DS" in tokens[1]:
                        inter_file.write(f"{lc}\t\t(DL 02) (C {tokens[2]})\n")
                    else:
                        # Handle literals (values in quotes)
                        if "='" in tokens[2]:
                            littab_file.write(f"{lc}\t\t{lit_counter}\t{tokens[2]}\n")
                            inter_file.write(f"{lc}\t\t{ins} {reg} (L {lit_counter})\n")
                            lit_counter += 1
                        # Handle symbols (variables/labels)
                        else:
                            symtab_file.write(f"{lc} {sym_counter} {tokens[2]}\n")
                            inter_file.write(f"{lc}\t\t{ins} {reg} (S {sym_counter})\n")
                            symtab.append(tokens[2])
                            sym_counter += 1

                # Handle single token instructions (LTORG, END)
                if len(tokens) == 1:
                    inter_file.write("\t\t(AD 05)" if "LTORG" in tokens[0] else "\n\t\t(AD 02)\n")

        print("Assembly code processing completed successfully.")

    except FileNotFoundError as e:
        print(f"Error: File not found - {e}")
    except Exception as e:
        print(f"Error occurred: {e}")

# Execute the assembly code processing function
process_assembly_code()