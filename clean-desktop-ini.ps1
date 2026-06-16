# Removes Windows desktop.ini junk files from the project (skips .git and build dirs).
# Run from anywhere:  pwsh C:\Users\was\IdeaProjects\ott\clean-desktop-ini.ps1
$root = "C:\Users\was\IdeaProjects\ott"
$files = Get-ChildItem -Path $root -Recurse -Force -Filter "desktop.ini" -File -ErrorAction SilentlyContinue |
    Where-Object { $_.FullName -notmatch '\\\.git\\' -and $_.FullName -notmatch '\\build\\' }
if (-not $files) { Write-Host "No desktop.ini files found."; return }
Write-Host "Deleting $($files.Count) desktop.ini file(s)..."
$files | ForEach-Object { Remove-Item -LiteralPath $_.FullName -Force; Write-Host "  removed $($_.FullName.Substring($root.Length+1))" }
Write-Host "Done."
