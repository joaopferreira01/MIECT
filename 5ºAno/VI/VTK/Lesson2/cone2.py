import time
from vtkmodules.all import *

def main():
    # Fonte para os cones com maior resolução e dimensões ajustadas
    coneSource = vtkConeSource()
    coneSource.SetHeight(2.0)       # Define a altura do cone
    coneSource.SetRadius(1.0)       # Define o raio da base do cone
    coneSource.SetResolution(50)    # Aumenta a resolução para um cone mais suave

    # Mapper compartilhado para os dois cones
    coneMapper = vtkPolyDataMapper()
    coneMapper.SetInputConnection(coneSource.GetOutputPort())

    # Primeiro ator (cone)
    coneActor1 = vtkActor()
    coneActor1.SetMapper(coneMapper)
    coneActor1.GetProperty().SetColor(0.2, 0.63, 0.79)

    # Segundo ator (cone)
    coneActor2 = vtkActor()
    coneActor2.SetMapper(coneMapper)
    coneActor2.GetProperty().SetColor(1.0, 0.3882, 0.2784)
    coneActor2.SetPosition(0, 2, 0)

    # Primeiro renderizador (esquerda)
    renderer1 = vtkRenderer()
    renderer1.AddActor(coneActor1)
    renderer1.SetBackground(0.1, 0.2, 0.4)
    renderer1.SetViewport(0.0, 0.0, 0.5, 1.0)  # Metade esquerda da janela

    # Segundo renderizador (direita)
    renderer2 = vtkRenderer()
    renderer2.AddActor(coneActor2)
    renderer2.SetBackground(0.2, 0.3, 0.4)
    renderer2.SetViewport(0.5, 0.0, 1.0, 1.0)  # Metade direita da janela

    # Ajusta a câmera do segundo renderizador
    renderer2.GetActiveCamera().Azimuth(90)

    # Janela de renderização
    renWin = vtkRenderWindow()
    renWin.AddRenderer(renderer1)
    renWin.AddRenderer(renderer2)
    renWin.SetSize(600, 300)
    renWin.SetWindowName("Cone Example with Two Viewports")

    # Interator para interatividade
    iren = vtkRenderWindowInteractor()
    iren.SetRenderWindow(renWin)

    # Função para girar os cones
    def rotate_cones():
        for _ in range(360):
            renderer1.GetActiveCamera().Azimuth(1)
            renderer2.GetActiveCamera().Azimuth(1)
            renWin.Render()
            time.sleep(0.01)

    # Inicia a interação
    iren.Initialize()
    rotate_cones()
    iren.Start()

if __name__ == "__main__":
    main()