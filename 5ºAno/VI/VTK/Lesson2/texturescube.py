import vtk

def create_textured_plane(image_path, translation, rotation):
    # Create the plane source
    plane = vtk.vtkPlaneSource()
    plane.SetXResolution(10)
    plane.SetYResolution(10)

    # Load the texture image
    reader = vtk.vtkJPEGReader()
    reader.SetFileName(image_path)

    texture = vtk.vtkTexture()
    texture.SetInputConnection(reader.GetOutputPort())

    # Define the transformation
    transform = vtk.vtkTransform()
    transform.Translate(*translation)
    transform.RotateX(rotation[0])
    transform.RotateY(rotation[1])
    transform.RotateZ(rotation[2])

    # Apply the transformation using vtkTransformPolyDataFilter
    transformFilter = vtk.vtkTransformPolyDataFilter()
    transformFilter.SetTransform(transform)
    transformFilter.SetInputConnection(plane.GetOutputPort())

    # Create the mapper
    mapper = vtk.vtkPolyDataMapper()
    mapper.SetInputConnection(transformFilter.GetOutputPort())

    # Create the actor and apply the texture
    actor = vtk.vtkActor()
    actor.SetMapper(mapper)
    actor.SetTexture(texture)

    return actor

def main():
    # Paths to texture images (replace with your image paths)
    image_paths = [
        "./images/Im1.jpg",
        "./images/Im2.jpg",
        "./images/Im3.jpg",
        "./images/Im4.jpg",
        "./images/Im5.jpg",
        "./images/Im6.jpg"
    ]

    # Define transformations for each plane (translation and rotation)
    transformations = [
        # Front Face
        ([0, 0, 0.5], [0, 0, 0]),
        # Back Face
        ([0, 0, -0.5], [0, 180, 0]),
        # Top Face
        ([0, 0.5, 0], [90, 0, 0]),
        # Bottom Face
        ([0, -0.5, 0], [-90, 0, 0]),
        # Right Face
        ([0.5, 0, 0], [0, 90, 0]),
        # Left Face
        ([-0.5, 0, 0], [0, -90, 0])
    ]

    # Create the renderer
    renderer = vtk.vtkRenderer()
    renderer.SetBackground(0.1, 0.1, 0.1)  # Dark background to highlight the cube

    # Create and add each textured plane to the renderer
    for i in range(6):
        actor = create_textured_plane(image_paths[i], transformations[i][0], transformations[i][1])
        renderer.AddActor(actor)

    # Create the render window
    renderWindow = vtk.vtkRenderWindow()
    renderWindow.AddRenderer(renderer)
    renderWindow.SetSize(800, 600)
    renderWindow.SetWindowName("Textured Cube")

    # Create the render window interactor
    interactor = vtk.vtkRenderWindowInteractor()
    interactor.SetRenderWindow(renderWindow)

    # Start interaction
    renderWindow.Render()
    interactor.Start()

if __name__ == "__main__":
    main()