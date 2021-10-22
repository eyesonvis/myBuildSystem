def call(repo, branch, destination = ''){
   echo "Cloning $repo"
   cloneDir = destination + repo.tokenize("/").last()

   bat "if exist \"$cloneDir\" rmdir /S /Q \"$cloneDir\""
   bat "mkdir \"$cloneDir\""

   if(!branch  || branch == null){
      branch = 'main'
      // above default branch name used to be master
   }

   dir(cloneDir){
      git url: repo, branch: branch
   }

   return cloneDir
}
