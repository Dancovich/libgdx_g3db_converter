![logo](http://libgdx.badlogicgames.com/img/logo.png)
![logo](http://download.blender.org/institute/logos/blender-plain.png)

G3DJ to G3DB Converter
====================

This is a small utility to convert 3D models in the G3DJ format (JSON based) to the G3DB format (binary JSON).

G3D is a custom 3D model file format compatible with the LibGDX framework (http://http://libgdx.badlogicgames.com/). The format is easy enough to allow use for other frameworks and is powerfull enough to support most features for game development, like multiple materials, multiple textures, different kinds of textures (diffuse maps, normal maps, etc.) and even armature based animations. The specification for this format can be found at [the project's wiki page](https://github.com/libgdx/fbx-conv/wiki) (work in progress).

This software is licensed under the [Apache 2 License](http://www.apache.org/licenses/LICENSE-2.0.html) (see LICENSE).

### Usage

You can use this utility from the command line. The basic command format is:

`java br.com.questingsoftware.libgdx.g3db.G3DBConverter /path/to/models/folder [true|false]`

where */path/to/models/folder* is a folder containing G3DJ files and the second (optional) argument is "true" to overwrite any existing files or "false" to generate a counter at the end of the file name to avoid overwriting files.

This class can also be called from inside your code, for that just call the `G3DBConverter#convertFolder` or `G3DBConverter#convert` method. See javadoc for usage.

