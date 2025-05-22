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

On GITHUB
  1. click on Pull requests
  2. Open the Pull request
  3. Check - no conflicts with base branch
  4. Click GREEN button - merge pull request
  5. Click GREEN button - confirm merge
  6. Delete branch
-------------------------------------------------------------
Steps to Clone GitHub Repo
•	On the GitHub page of the Repository
•	Click green button ‘<>Code’
•	Copy the SSH URL

Open IntelliJ 
•	FILE > New > Project from Version Control
•	Paste the github Repo URL
•	Check the directory (which file you want to clone it to)
•	Click Clone
(This will download the repo, open the new project in either new window or current one( you will have option to select) and set it will set up .git tracking for the repo)

