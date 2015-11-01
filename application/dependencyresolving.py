import json

class Project: 
    def __init__(self, name, data):
        self.projectName = str(name)
        self.dependencies = data
        
    def __str__(self):
        return self.projectName
        
    def __repr__(self):
        return self.__str__()
        
    def __hash__(self):
        return hash(self.__str__())    
    
    def __iter__(self):
        return iter(self.__str__())    
        

class DependencyResolving:
    def __init__(self):
        self.packages = {}
        self.projectsList = []
        self.installed = set()
        
    def has_project(self, project):
        return project in self.projectsList

    def add_project(self, project):
        if self.has_project(project):
            raise Exception("Project already in project list")
        self.projectsList.append(project)
              
                
    def resolve(self):
        for project in self.projectsList:
            for dependency in project.dependencies:
                self.install(dependency)
        print("All done.")                


    def install(self,dependency):
        if(dependency in self.installed):
            print("{} is already installed".format(dependency))
            return
        print("Installing {}".format(dependency))
        dependencies = self.packages[dependency]
        for innerdep in dependencies:
            print("In order to install {} we need {}".format(dependency, innerdep))
            self.install(innerdep)
            self.installed.add(innerdep)
        return


    def load_packages(self,filename):
        with open(filename, "r") as f:
            contents = f.read()
            self.packages = json.loads(contents)
            
    def load_dependencies(self, filename):
        with open(filename, "r") as fp:
            data = json.load(fp)
            pr = Project(data["projectName"], data["dependencies"])
            self.add_project(pr)        
            

dep = DependencyResolving()
dep.load_dependencies("dependencies.json")
dep.load_packages("all_packages.json")
dep.resolve()
        

  
