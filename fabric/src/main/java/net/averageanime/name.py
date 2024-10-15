import os
import stat
import traceback

def rename_villagerplus(path="."):

  """
  Renames all instances of "VillagerPlus" (case-insensitive) to  
  "DelightfulChefs" in files and folders, including the content  
  within the files, in the directory where the script is located.  
  Also renames "com.lion" to "net.averageanime" and "lion" to  
  "averageanime".  
  Ensures the script has necessary permissions to modify files and folders.  
  Ignores the ".gradle", ".github", ".idea", "gradle", "build", and  
  "run" folders, and files named "name.py".

  Args:
    path: The path to the directory. Defaults to the current directory (".").
  """

  ignored_folders = [".gradle", ".github", ".idea", "gradle", "build", "run"]
  ignored_files = ["name.py"]

  try:
    for root, dirs, files in os.walk(path):
      dirs[:] = [d for d in dirs if d not in ignored_folders]

      for filename in files:
        if filename in ignored_files:
          print(f"Skipping ignored file: {os.path.join(root, filename)}")
          continue

        old_filepath = os.path.join(root, filename)
        new_filename = filename.replace("DelightfulChefs", "CreateEngineers")
        new_filename = new_filename.replace("delightfulchefs", "createengineers")
        new_filename = new_filename.replace("DELIGHTFULCHEFS", "CREATEENGINEERS")
        # Add renaming for "com.lion" and "lion"
        new_filename = new_filename.replace("com.lion", "net.averageanime")
        new_filename = new_filename.replace("lion", "averageanime")
        new_filepath = os.path.join(root, new_filename)

        print(f"Renaming file: {old_filepath} -> {new_filepath}")
        try:
          os.chmod(old_filepath, stat.S_IWRITE)
          os.rename(old_filepath, new_filepath)

          with open(new_filepath, 'r') as f:
            file_content = f.read()
          file_content = file_content.replace("DelightfulChefs", "CreateEngineers")
          file_content = file_content.replace("delightfulchefs", "createengineers")
          file_content = file_content.replace("DELIGHTFULCHEFS", "CREATEENGINEERS")
          # Add renaming for "com.lion" and "lion" in file content
          file_content = file_content.replace("com.lion", "net.averageanime")
          file_content = file_content.replace("lion", "averageanime")
          with open(new_filepath, 'w') as f:
            f.write(file_content)
          print(f"  Replaced text in: {new_filepath}")
        except (OSError, UnicodeDecodeError) as e:
          print(f"  Error processing file: {old_filepath} - {e}")

      for dirname in dirs:
        old_dirpath = os.path.join(root, dirname)
        new_dirname = dirname.replace("DelightfulChefs", "CreateEngineers")
        new_dirname = new_dirname.replace("delightfulchefs", "createengineers")
        new_dirname = new_dirname.replace("DELIGHTFULCHEFS", "CREATEENGINEERS")
        # Add renaming for "com.lion" and "lion" in directory names
        new_dirname = new_dirname.replace("com.lion", "net.averageanime")
        new_dirname = new_dirname.replace("lion", "averageanime")
        new_dirpath = os.path.join(root, new_dirname)

        print(f"Renaming directory: {old_dirpath} -> {new_dirpath}")
        try:
          os.chmod(old_dirpath, stat.S_IWRITE)
          os.rename(old_dirpath, new_dirpath)
        except OSError as e:
          print(f"  Error processing directory: {old_dirpath} - {e}")

  except Exception as e:
    print("An error occurred:")
    traceback.print_exc()  # Print the full traceback
    input("Press Enter to close...")

# Run the function for the current directory
rename_villagerplus()