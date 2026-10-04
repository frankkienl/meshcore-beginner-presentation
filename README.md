# MeshCore presentation, based on CuP

This is a MeshCore presentation, build using [Compose ur Pres](https://github.com/KodeinKoders/CuP) project.
  
  
To view the presentation, go to Github Pages;

https://frankkienl.github.io/meshcore-beginner-presentation/


Note: Web-version does not include the speaker-notes;
Only the Desktop version does.

## Developer instructions:  
  
1. Run the presentation:
    - On desktop with the `./gradlew hotRunJvm` to use Compose Hot Reload.
    - On the web (if you chose to target it) with the `./gradlew wasmJsBrowserDevelopmentRun` command.
2. Export the presentation web page (if targetting the web):
    - If you are using Github Pages, everything is taken care of by [.github/workflows/pages.yml](.github/workflows/pages.yml).
    - If you are using another system, run the `./gradlew composeCompatibilityBrowserDistribution`  command that will generate the web page in the `build/dist/composeWebCompatibility/productionExecutable` directory.