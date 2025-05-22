Tech Notes
On Terminal Sequence to push code from InteliJ to GitHub
Steps:
  1. git status (check status - ensure there is 'nothing to commit, working tree is clean'
  2. gaa (git add)
  3. git commit - m " COMMIT MESSAGE " (add a message to the commit)
  4. git push origin BRANCHNAME (push the code to branch you're working on)
  5. git status (check if the commit worked)

When starting a new branch
1. git checkout main (this allows a new branch to be created)
2. git pull origin main
3. git status (check this Before checking out a new branch)
4. git checkout -b "NewBranchName" 
