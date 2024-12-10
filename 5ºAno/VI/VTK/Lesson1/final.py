from vtkmodules.all import *

def add_light(renderer, color, position):
    """
    Adds a light to the renderer with the specified color and position.
    """
    light = vtkLight()
    light.SetColor(color)
    light.SetPosition(position)
    light.SetFocalPoint(0, 0, 0)  # Pointing towards the origin
    renderer.AddLight(light)

def add_light_sphere(renderer, color, position, radius=0.5):
    """
    Adds a sphere at the position of the light source with the specified color.
    """
    sphereSource = vtkSphereSource()
    sphereSource.SetRadius(radius)
    sphereSource.SetCenter(position)

    sphereMapper = vtkPolyDataMapper()
    sphereMapper.SetInputConnection(sphereSource.GetOutputPort())

    sphereActor = vtkActor()
    sphereActor.SetMapper(sphereMapper)

    # Set sphere color and disable lighting
    sphereActor.GetProperty().SetColor(color)
    sphereActor.GetProperty().LightingOff()  # Prevents lighting from affecting the sphere

    renderer.AddActor(sphereActor)

def main():
    # Renderer setup
    ren = vtkRenderer()
    ren.SetBackground(0.1, 0.1, 0.1)  # Dark gray background

    # Render window setup
    renWin = vtkRenderWindow()
    renWin.AddRenderer(ren)
    renWin.SetWindowName('Lighting Example')
    renWin.SetSize(600, 600)

    # Interaction setup
    iren = vtkRenderWindowInteractor()
    iren.SetRenderWindow(renWin)

    # Create a primary object (e.g., a sphere)
    objectSource = vtkSphereSource()
    objectSource.SetRadius(2.0)
    objectSource.SetThetaResolution(50)
    objectSource.SetPhiResolution(50)

    objectMapper = vtkPolyDataMapper()
    objectMapper.SetInputConnection(objectSource.GetOutputPort())

    objectActor = vtkActor()
    objectActor.SetMapper(objectMapper)
    objectActor.GetProperty().SetColor(1.0, 1.0, 1.0)  # White object

    ren.AddActor(objectActor)

    # Add lights with corresponding spheres
    lights = [
        {'color': (1, 0, 0), 'position': (-5, 0, 0)},  # Red light
        {'color': (0, 1, 0), 'position': (0, 0, -5)},  # Green light
        {'color': (0, 0, 1), 'position': (5, 0, 0)},   # Blue light
        {'color': (1, 1, 0), 'position': (0, 0, 5)},   # Yellow light
    ]

    for light in lights:
        add_light(ren, light['color'], light['position'])
        add_light_sphere(ren, light['color'], light['position'])

    # Render and start interaction
    renWin.Render()
    iren.Start()


if __name__ == '__main__':
    main()
from vtkmodules.all import *
