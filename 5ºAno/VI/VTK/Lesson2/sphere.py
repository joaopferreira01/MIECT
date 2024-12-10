import time
from vtkmodules.all import (
    vtkSphereSource,
    vtkPolyDataMapper,
    vtkActor,
    vtkRenderer,
    vtkRenderWindow,
    vtkRenderWindowInteractor
)


def main():
    # Fonte para as esferas
    sphereSource1 = vtkSphereSource()
    sphereSource2 = vtkSphereSource()

    # Mapper compartilhado para a primeira esfera
    sphereMapper1 = vtkPolyDataMapper()
    sphereMapper1.SetInputConnection(sphereSource1.GetOutputPort())

    # Mapper para a segunda esfera
    sphereMapper2 = vtkPolyDataMapper()
    sphereMapper2.SetInputConnection(sphereSource2.GetOutputPort())

    # Primeiro ator (esfera)
    sphereActor1 = vtkActor()
    sphereActor1.SetMapper(sphereMapper1)
    sphereActor1.GetProperty().SetColor(0.2, 0.63, 0.79)

    # Segundo ator (esfera com flat shading)
    sphereActor2 = vtkActor()
    sphereActor2.SetMapper(sphereMapper2)
    sphereActor2.GetProperty().SetColor(1.0, 0.3882, 0.2784)
    
    #Altera shading
    # sphereActor2.GetProperty().SetInterpolationToFlat()  # Flat shading
    # sphereActor2.GetProperty().SetInterpolationToGouraud()
    sphereActor2.GetProperty().SetInterpolationToPhong()


    sphereActor2.SetPosition(0, 2, 0)

    # Primeiro renderizador (esquerda)
    renderer1 = vtkRenderer()
    renderer1.AddActor(sphereActor1)
    renderer1.SetBackground(0.1, 0.2, 0.4)
    renderer1.SetViewport(0.0, 0.0, 0.5, 1.0)  # Metade esquerda da janela

    # Segundo renderizador (direita)
    renderer2 = vtkRenderer()
    renderer2.AddActor(sphereActor2)
    renderer2.SetBackground(0.2, 0.3, 0.4)
    renderer2.SetViewport(0.5, 0.0, 1.0, 1.0)  # Metade direita da janela

    # Ajusta a câmera do segundo renderizador
    renderer2.GetActiveCamera().Azimuth(90)

    # Janela de renderização
    renWin = vtkRenderWindow()
    renWin.AddRenderer(renderer1)
    renWin.AddRenderer(renderer2)
    renWin.SetSize(600, 300)
    renWin.SetWindowName("Sphere Example with Two Viewports and Different Shading")

    # Interator para interatividade
    iren = vtkRenderWindowInteractor()
    iren.SetRenderWindow(renWin)

    # Função para girar as esferas
    def rotate_spheres():
        for _ in range(360):
            renderer1.GetActiveCamera().Azimuth(1)
            renderer2.GetActiveCamera().Azimuth(1)
            renWin.Render()
            time.sleep(0.01)

    # Inicia a interação
    iren.Initialize()
    rotate_spheres()
    iren.Start()


if __name__ == "__main__":
    main()
