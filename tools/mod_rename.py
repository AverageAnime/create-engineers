import os
import stat
import traceback

def mod_rename(path="."):

  """
  
  Args:
    path: The path to the directory. Defaults to the current directory (".").
  """

  ignored_folders = [".gradle", ".github", ".idea", "gradle", "build", "run"]
  ignored_files = ["mod_rename.py"]

  try:
    for root, dirs, files in os.walk(path):
      dirs[:] = [d for d in dirs if d not in ignored_folders]

      for filename in files:
        if filename in ignored_files:
          print(f"Skipping ignored file: {os.path.join(root, filename)}")
          continue

        old_filepath = os.path.join(root, filename)
        new_filename = filename.replace("DelightfulTrades", "CreateEngineers")
        new_filename = new_filename.replace("delightfultrades", "createengineers")
        new_filename = new_filename.replace("DELIGHTFULTRADES", "CREATEENGINEERS")
        new_filepath = os.path.join(root, new_filename)

        print(f"Renaming file: {old_filepath} -> {new_filepath}")
        try:
          os.chmod(old_filepath, stat.S_IWRITE)
          os.rename(old_filepath, new_filepath)

          with open(new_filepath, 'r') as f:
            file_content = f.read()
          file_content = file_content.replace("DelightfulTrades", "CreateEngineers")
          file_content = file_content.replace("delightfultrades", "createengineers")
          file_content = file_content.replace("DELIGHTFULTRADES", "CREATEENGINEERS")
          with open(new_filepath, 'w') as f:
            f.write(file_content)
          print(f"  Replaced text in: {new_filepath}")
        except (OSError, UnicodeDecodeError) as e:
          print(f"  Error processing file: {old_filepath} - {e}")

      for dirname in dirs:
        old_dirpath = os.path.join(root, dirname)
        new_dirname = dirname.replace("DelightfulTrades", "CreateEngineers")
        new_dirname = new_dirname.replace("delightfultrades", "createengineers")
        new_dirname = new_dirname.replace("DELIGHTFULTRADES", "CREATEENGINEERS")
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
mod_rename()